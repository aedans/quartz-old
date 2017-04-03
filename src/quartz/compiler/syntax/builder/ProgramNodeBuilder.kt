package quartz.compiler.syntax.builder

import quartz.compiler.exceptions.QuartzException
import quartz.compiler.parser.QuartzParser
import quartz.compiler.syntax.tree.ProgramNode
import quartz.compiler.syntax.tree.function.FnDeclarationNode
import quartz.compiler.syntax.tree.import.Library
import quartz.compiler.syntax.tree.import.import
import quartz.compiler.syntax.tree.misc.ExternFnDeclarationNode
import quartz.compiler.syntax.tree.misc.InlineCNode
import quartz.compiler.syntax.tree.misc.TypealiasNode
import quartz.compiler.syntax.tree.struct.StructDeclarationNode
import java.io.InputStream

/**
 * Created by Aedan Smith.
 */

fun QuartzParser.ProgramContext.toNode(library: Library.LibraryPackage, parser: (InputStream) -> QuartzParser.ProgramContext): ProgramNode {
    val nodes = declaration().map { it.toNode() } + importDeclaration().map { it.import(library, parser) }.flatten().map { it.toNode() }
    val programNode = ProgramNode(
            nodes.filterIsInstance(FnDeclarationNode::class.java),
            nodes.filterIsInstance(ExternFnDeclarationNode::class.java),
            nodes.filterIsInstance(StructDeclarationNode::class.java),
            nodes.filterIsInstance(TypealiasNode::class.java),
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
        inlineC() != null -> inlineC().toNode().also { println("Found $it\n") }
        else -> throw QuartzException("Error translating $text")
    }.also { println("Found $it") }
}
