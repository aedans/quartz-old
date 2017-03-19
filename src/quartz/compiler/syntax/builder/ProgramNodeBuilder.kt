package quartz.compiler.syntax.builder

import quartz.compiler.parser.QuartzParser
import quartz.compiler.syntax.builder.program.toNode
import quartz.compiler.syntax.tree.ProgramNode

/**
 * Created by Aedan Smith.
 */

fun QuartzParser.ProgramContext.toNode(): ProgramNode {
    val programNode = ProgramNode()
    this.declaration().forEach {
        it.addTo(programNode)
        println()
    }
    return programNode
}

private fun QuartzParser.DeclarationContext.addTo(programNode: ProgramNode) {
    if (fnDeclaration() != null) {
        val fnDeclarationNode = fnDeclaration().toNode()
        programNode.fnDeclarations.add(fnDeclarationNode)
        println("Found $fnDeclarationNode")
    } else if (externFnDeclaration() != null) {
        val externFn = externFnDeclaration().toNode()
        programNode.externFnDeclarations.add(externFn)
        println("Found $externFn")
    } else if (inlineC() != null) {
        val inlineCNode = inlineC().toNode()
        programNode.inlineCNodes.add(inlineCNode)
        println("Found $inlineCNode")
    } else {
        throw Exception("Error translating $this")
    }
}
