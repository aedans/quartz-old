package quartz.compiler.syntax.builder

import quartz.compiler.exceptions.QuartzException
import quartz.compiler.parser.QuartzParser
import quartz.compiler.syntax.tree.ProgramNode
import quartz.compiler.syntax.tree.function.FnDeclarationNode
import quartz.compiler.syntax.tree.misc.InlineCNode
import quartz.compiler.syntax.tree.struct.StructDeclarationNode
import quartz.compiler.util.Function

/**
 * Created by Aedan Smith.
 */

fun QuartzParser.ProgramContext.toNode(): ProgramNode {
    val nodes = declaration().map { it.toNode() }
    val programNode = ProgramNode(
            nodes.filterIsInstance(FnDeclarationNode::class.java),
            nodes.filterIsInstance(StructDeclarationNode::class.java),
            nodes.filterIsInstance(Function::class.java),
            nodes.filterIsInstance(InlineCNode::class.java)
    )
    return programNode
}

fun QuartzParser.DeclarationContext.toNode(): Any {
    return when {
        fnDeclaration() != null -> {
            val fnDeclarationNode = fnDeclaration().toNode()
            println("Found $fnDeclarationNode\n")
            fnDeclarationNode
        }
        externFnDeclaration() != null -> {
            val externFn = externFnDeclaration().toNode()
            println("Found $externFn\n")
            externFn
        }
        inlineC() != null -> {
            val inlineCNode = inlineC().toNode()
            println("Found $inlineCNode\n")
            inlineCNode
        }
        structDeclaration() != null -> {
            val structNode = structDeclaration().toNode()
            println("Found $structNode\n")
            structNode
        }
        else -> throw QuartzException("Error translating $text")
    }
}
