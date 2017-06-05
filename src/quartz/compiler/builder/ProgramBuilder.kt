package quartz.compiler.builder

import quartz.compiler.errors.QuartzException
import quartz.compiler.errors.errorScope
import quartz.compiler.parser.QuartzParser
import quartz.compiler.tree.Declaration
import quartz.compiler.tree.Library
import quartz.compiler.tree.Program
import java.io.InputStream

/**
 * Created by Aedan Smith.
 */

fun QuartzParser.ProgramContext.toNode(library: Library.LibraryPackage, parser: (InputStream) -> QuartzParser.ProgramContext): Program {
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
            it.inlineC() != null -> program += it.inlineC().toNode()
            it.functionDeclaration() != null -> program += it.functionDeclaration().toNode()
            it.externFunctionDeclaration() != null -> program += it.externFunctionDeclaration().toNode()
            it.typealiasDeclaration() != null -> program += it.typealiasDeclaration().toNode()
            else -> throw QuartzException("Error translating ${it.text}")
        }
    }
    return program
}
