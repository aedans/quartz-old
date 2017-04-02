package quartz.compiler.syntax.tree

import quartz.compiler.semantics.generateSymbolTable
import quartz.compiler.syntax.tree.function.ExpressionNode
import quartz.compiler.syntax.tree.function.FnDeclarationNode
import quartz.compiler.syntax.tree.misc.ExternFnDeclarationNode
import quartz.compiler.syntax.tree.misc.InlineCNode
import quartz.compiler.syntax.tree.misc.TypealiasNode
import quartz.compiler.syntax.tree.struct.StructDeclarationNode
import quartz.compiler.util.Type

/**
 * Created by Aedan Smith.
 */

data class ProgramNode(
        val fnDeclarations: List<FnDeclarationNode>,
        val structDeclarations: List<StructDeclarationNode>,
        val externFnDeclarations: List<ExternFnDeclarationNode>,
        val typealiasDeclarations: List<TypealiasNode>,
        val inlineCNodes: List<InlineCNode>
) {
    val symbolTable = generateSymbolTable()

    fun mapExpressions(function: (ExpressionNode) -> ExpressionNode): ProgramNode {
        return ProgramNode(
                fnDeclarations.map { it.mapExpressions(function) },
                structDeclarations,
                externFnDeclarations,
                typealiasDeclarations,
                inlineCNodes
        )
    }

    fun mapTypes(function: (Type?) -> Type?): ProgramNode {
        return ProgramNode(
                fnDeclarations.map { it.mapTypes(function) },
                structDeclarations.map { it.mapTypes(function) },
                externFnDeclarations.map { it.mapTypes(function) },
                typealiasDeclarations.map { it.mapTypes(function) },
                inlineCNodes
        )
    }

    override fun toString(): String {
        var s = ""
        fnDeclarations.forEach { s += it.toString() + "\n\n" }
        structDeclarations.forEach { s += it.toString() + "\n\n" }
        return s
    }
}