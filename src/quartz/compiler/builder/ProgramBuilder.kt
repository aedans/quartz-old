package quartz.compiler.builder

import quartz.compiler.errors.QuartzException
import quartz.compiler.parser.QuartzParser
import quartz.compiler.tree.GlobalDeclaration
import quartz.compiler.tree.Program
import quartz.compiler.tree.function.FunctionDeclaration
import quartz.compiler.tree.library.Library
import quartz.compiler.tree.misc.ExternFunctionDeclaration
import quartz.compiler.tree.misc.InlineC
import quartz.compiler.tree.misc.TypealiasDeclaration
import quartz.compiler.tree.struct.StructDeclaration
import java.io.InputStream

/**
 * Created by Aedan Smith.
 */

fun QuartzParser.ProgramContext.toNode(library: Library.LibraryPackage, parser: (InputStream) -> QuartzParser.ProgramContext): Program {
    val nodes = declaration().map { it.toNode() } +
            importDeclaration().map { it.import(library, parser) }.flatten().map { it.toNode() } +
            parser(library.get(listOf("std", "_default")).inputStream()).declaration().map { it.toNode() }
    val programNode = Program(
            nodes.filterIsInstance(FunctionDeclaration::class.java).map { it.name to it }.toMap(),
            nodes.filterIsInstance(ExternFunctionDeclaration::class.java).map { it.name to it }.toMap(),
            nodes.filterIsInstance(StructDeclaration::class.java).map { it.name to it }.toMap(),
            nodes.filterIsInstance(TypealiasDeclaration::class.java).map { it.name to it }.toMap(),
            nodes.filterIsInstance(InlineC::class.java)
    )
    return programNode
}

fun QuartzParser.DeclarationContext.toNode(): GlobalDeclaration {
    return when {
        functionDeclaration() != null -> functionDeclaration().toNode()
        externFunctionDeclaration() != null -> externFunctionDeclaration().toNode()
        structDeclaration() != null -> structDeclaration().toNode()
        typealiasDeclaration() != null -> typealiasDeclaration().toNode()
        inlineC() != null -> inlineC().toNode()
        else -> throw QuartzException("Error translating $text")
    }.also { println("Found $it\n") }
}
