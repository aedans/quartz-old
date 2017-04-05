package quartz.compiler.builder

import quartz.compiler.exceptions.QuartzException
import quartz.compiler.parser.QuartzParser
import quartz.compiler.tree.ProgramNode
import quartz.compiler.tree.function.FnDeclarationNode
import quartz.compiler.tree.import.Library
import quartz.compiler.tree.import.import
import quartz.compiler.tree.misc.ExternFnDeclarationNode
import quartz.compiler.tree.misc.InlineCNode
import quartz.compiler.tree.misc.TypealiasNode
import quartz.compiler.tree.struct.StructDeclarationNode
import java.io.InputStream

/**
 * Created by Aedan Smith.
 */

fun QuartzParser.ProgramContext.toNode(library: Library.LibraryPackage, parser: (InputStream) -> QuartzParser.ProgramContext): ProgramNode {
    val nodes = declaration().map { it.toNode() } + importDeclaration().map { it.import(library, parser) }.flatten().map { it.toNode() }
    val programNode = ProgramNode(
            nodes.filterIsInstance(FnDeclarationNode::class.java).map { it.name to it }.toMap(),
            nodes.filterIsInstance(ExternFnDeclarationNode::class.java).map { it.name to it }.toMap(),
            nodes.filterIsInstance(StructDeclarationNode::class.java).map { it.name to it }.toMap(),
            nodes.filterIsInstance(TypealiasNode::class.java).map { it.name to it }.toMap(),
            nodes.filterIsInstance(InlineCNode::class.java)
    )
    return programNode
}

@Suppress("IMPLICIT_CAST_TO_ANY")
fun QuartzParser.DeclarationContext.toNode(): Any {
    return when {
        fnDeclaration() != null -> fnDeclaration().toNode()
        structDeclaration() != null -> structDeclaration().toNode()
        typealiasDeclaration() != null -> typealiasDeclaration().toNode()
        inlineC() != null -> inlineC().toNode()
        else -> throw QuartzException("Error translating $text")
    }.also { println("Found $it") }
}
