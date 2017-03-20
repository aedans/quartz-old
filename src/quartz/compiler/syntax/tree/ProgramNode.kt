package quartz.compiler.syntax.tree

import quartz.compiler.syntax.tree.program.FnDeclarationNode
import quartz.compiler.syntax.tree.program.InlineCNode
import quartz.compiler.util.Function

/**
 * Created by Aedan Smith.
 */

class ProgramNode {
    val fnDeclarations = mutableListOf<FnDeclarationNode>()
    val externFnDeclarations = mutableListOf<Function>()
    val inlineCNodes = mutableListOf<InlineCNode>()

    override fun toString(): String {
        var s = ""
        fnDeclarations.forEach { s += it.toString() + "\n\n" }
        return s
    }
}