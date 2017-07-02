package quartz.compiler.builder

import quartz.compiler.errors.errorScope
import quartz.compiler.errors.except
import quartz.compiler.parser.QuartzParser
import quartz.compiler.tree.Declaration
import quartz.compiler.tree.Library
import quartz.compiler.tree.Program
import java.io.InputStream

/**
 * Created by Aedan Smith.
 */

fun QuartzParser.ProgramContext.toExpr(library: Library.LibraryPackage, parser: (InputStream) -> QuartzParser.ProgramContext): Program {
    val nodes: List<QuartzParser.DeclarationContext> = declaration() +
            importDeclaration().map { it.import(library, parser) }.flatten() +
            errorScope({ "_default.qz" }) {
                parser(library.get(listOf("std", "_default")).inputStream()).declaration()
            }
    return nodes.program()
}

private fun List<QuartzParser.DeclarationContext>.program(): Program {
    var program = emptyList<Declaration>()
    forEach {
        when {
            it.inlineC() != null -> program += it.inlineC().toExpr()
            it.functionDeclaration() != null -> program += it.functionDeclaration().toExpr()
            it.externFunctionDeclaration() != null -> program += it.externFunctionDeclaration().toExpr()
            it.typealiasDeclaration() != null -> program += it.typealiasDeclaration().toExpr()
            else -> except { "Error translating ${it.text}" }
        }
    }
    return program
}
