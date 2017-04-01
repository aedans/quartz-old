package quartz.compiler.syntax.tree

import quartz.compiler.syntax.tree.function.FnDeclarationNode
import quartz.compiler.syntax.tree.misc.ExternFnDeclarationNode
import quartz.compiler.syntax.tree.misc.InlineCNode
import quartz.compiler.syntax.tree.struct.StructDeclarationNode

/**
 * Created by Aedan Smith.
 */

data class ProgramNode(
        val fnDeclarations: List<FnDeclarationNode>,
        val structDeclarations: List<StructDeclarationNode>,
        val externFnDeclarations: List<ExternFnDeclarationNode>,
        val inlineCNodes: List<InlineCNode>
) {
    override fun toString(): String {
        var s = ""
        fnDeclarations.forEach { s += it.toString() + "\n\n" }
        structDeclarations.forEach { s += it.toString() + "\n\n" }
        return s
    }
}