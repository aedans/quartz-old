package quartz.compiler.builder

import quartz.compiler.errors.errorScope
import quartz.compiler.errors.except
import quartz.compiler.parser.QuartzParser
import quartz.compiler.tree.Declaration
import quartz.compiler.tree.Program
import quartz.compiler.tree.util.Library
import java.io.InputStream

/**
 * Created by Aedan Smith.
 */

fun QuartzParser.ProgramContext.program(library: Library.LibraryPackage, parser: (InputStream) -> QuartzParser.ProgramContext): Program {
    val nodes: List<QuartzParser.DeclarationContext> = declaration() +
            importDeclaration().map { it.import(library, parser) }.flatten() +
            errorScope({ "_default.qz" }) {
                parser(library.get(listOf("std", "_default")).inputStream()).declaration()
            }
    return nodes.program()
}

private fun List<QuartzParser.DeclarationContext>.program(): Program {
    val program = mutableListOf<Declaration>()
    forEach {
        when {
            it.functionDeclaration() != null -> program.add(it.functionDeclaration().toDecl())
            it.externFunctionDeclaration() != null -> program.add(it.externFunctionDeclaration().toDecl())
            it.typealiasDeclaration() != null -> program.add(it.typealiasDeclaration().toDecl())
            it.inlineC() != null -> program.add(it.inlineC().toExpr())
            else -> except { "Error translating ${it.text}" }
        }
    }
    return program
}
