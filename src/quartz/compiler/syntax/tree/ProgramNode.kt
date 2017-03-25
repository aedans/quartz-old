package quartz.compiler.syntax.tree

import quartz.compiler.semantics.symboltable.GlobalSymbolTable
import quartz.compiler.syntax.tree.function.FnDeclarationNode
import quartz.compiler.syntax.tree.misc.InlineCNode
import quartz.compiler.syntax.tree.struct.StructDeclarationNode
import quartz.compiler.util.Function

/**
 * Created by Aedan Smith.
 */

data class ProgramNode(
        val fnDeclarations: List<FnDeclarationNode>,
        val structDeclarations: List<StructDeclarationNode>,
        val externFnDeclarations: List<Function>,
        val inlineCNodes: List<InlineCNode>
) {
    val symbolTable = GlobalSymbolTable()

    override fun toString(): String {
        var s = ""
        fnDeclarations.forEach { s += it.toString() + "\n\n" }
        structDeclarations.forEach { s += it.toString() + "\n\n" }
        return s
    }
}