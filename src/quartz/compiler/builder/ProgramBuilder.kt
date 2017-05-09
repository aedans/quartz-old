package quartz.compiler.builder

import quartz.compiler.errors.QuartzException
import quartz.compiler.errors.errorScope
import quartz.compiler.parser.QuartzParser
import quartz.compiler.tree.Program
import quartz.compiler.tree.library.Library
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
    return if (isEmpty()) Program() else when {
        first().inlineC() != null -> drop(1).program() + first().inlineC().toNode()
        first().functionDeclaration() != null -> drop(1).program() + first().functionDeclaration().toNode()
        first().externFunctionDeclaration() != null -> drop(1).program() + first().externFunctionDeclaration().toNode()
        first().structDeclaration() != null -> drop(1).program() + first().structDeclaration().toNode()
        first().typealiasDeclaration() != null -> drop(1).program() + first().typealiasDeclaration().toNode()
        else -> throw QuartzException("Error translating ${first().text}")
    }
}
