package quartz.compiler.syntax.tree

import quartz.compiler.syntax.tree.program.function.FnDeclarationNode
import quartz.compiler.syntax.tree.program.misc.InlineCNode
import quartz.compiler.syntax.tree.program.struct.StructDeclarationNode
import quartz.compiler.util.Function

/**
 * Created by Aedan Smith.
 */

class ProgramNode {
    val fnDeclarations = mutableListOf<FnDeclarationNode>()
    val structDeclarations = mutableListOf<StructDeclarationNode>()
    val externFnDeclarations = mutableListOf<Function>()
    val inlineCNodes = mutableListOf<InlineCNode>()

    override fun toString(): String {
        var s = ""
        fnDeclarations.forEach { s += it.toString() + "\n\n" }
        structDeclarations.forEach { s += it.toString() + "\n\n" }
        return s
    }
}