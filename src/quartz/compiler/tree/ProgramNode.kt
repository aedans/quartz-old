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

data class ProgramNode(
        val fnDeclarations: Map<String, FnDeclarationNode>,
        val externFnDeclarations: Map<String, ExternFnDeclarationNode>,
        val structDeclarations: Map<String, StructDeclarationNode>,
        val typealiasDeclarations: Map<String, TypealiasNode>,
        val inlineCNodes: List<InlineCNode>
) {
    val symbolTable = generateSymbolTable()

    fun mapFnDeclarations(function: (FnDeclarationNode) -> FnDeclarationNode): ProgramNode {
        return ProgramNode(
                fnDeclarations.mapValues { function(it.value) },
                externFnDeclarations,
                structDeclarations,
                typealiasDeclarations,
                inlineCNodes
        )
    }

    fun mapExpressions(function: (ExpressionNode) -> ExpressionNode): ProgramNode {
        return ProgramNode(
                fnDeclarations.mapValues { it.value.mapExpressions(function) },
                externFnDeclarations,
                structDeclarations,
                typealiasDeclarations,
                inlineCNodes
        )
    }

    fun mapTypes(function: (Type?) -> Type?): ProgramNode {
        return ProgramNode(
                fnDeclarations.mapValues { it.value.mapTypes(function) },
                externFnDeclarations.mapValues { it.value.mapTypes(function) },
                structDeclarations.mapValues { it.value.mapTypes(function) },
                typealiasDeclarations.mapValues { it.value.mapTypes(function) },
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