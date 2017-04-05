package quartz.compiler.tree

import quartz.compiler.semantics.symboltable.generateSymbolTable
import quartz.compiler.tree.function.ExpressionNode
import quartz.compiler.tree.function.FnDeclarationNode
import quartz.compiler.tree.misc.ExternFnDeclarationNode
import quartz.compiler.tree.misc.InlineCNode
import quartz.compiler.tree.misc.TypealiasNode
import quartz.compiler.tree.struct.StructDeclarationNode
import quartz.compiler.util.Type

/**
 * Created by Aedan Smith.
 */

// TODO Maps
data class ProgramNode(
        val fnDeclarations: List<FnDeclarationNode>,
        val externFnDeclarations: List<ExternFnDeclarationNode>,
        val structDeclarations: List<StructDeclarationNode>,
        val typealiasDeclarations: List<TypealiasNode>,
        val inlineCNodes: List<InlineCNode>
) {
    val symbolTable = generateSymbolTable()

    fun mapFnDeclarations(function: (FnDeclarationNode) -> FnDeclarationNode): ProgramNode {
        return ProgramNode(
                fnDeclarations.map(function),
                externFnDeclarations,
                structDeclarations,
                typealiasDeclarations,
                inlineCNodes
        )
    }

    fun mapExpressions(function: (ExpressionNode) -> ExpressionNode): ProgramNode {
        return ProgramNode(
                fnDeclarations.map { it.mapExpressions(function) },
                externFnDeclarations,
                structDeclarations,
                typealiasDeclarations,
                inlineCNodes
        )
    }

    fun mapTypes(function: (Type?) -> Type?): ProgramNode {
        return ProgramNode(
                fnDeclarations.map { it.mapTypes(function) },
                externFnDeclarations.map { it.mapTypes(function) },
                structDeclarations.map { it.mapTypes(function) },
                typealiasDeclarations.map { it.mapTypes(function) },
                inlineCNodes
        )
    }

    override fun toString(): String {
        var s = ""
        fnDeclarations.forEach { s += it.toString() + "\n\n" }
        structDeclarations.forEach { s += it.toString() + "\n\n" }
        typealiasDeclarations.forEach { s += it.toString() + "\n\n" }
        return s
    }
}