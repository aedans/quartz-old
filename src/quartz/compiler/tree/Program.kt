package quartz.compiler.tree

import quartz.compiler.semantics.symboltable.generateSymbolTable
import quartz.compiler.tree.function.Expression
import quartz.compiler.tree.function.FunctionDeclaration
import quartz.compiler.tree.misc.ExternFunctionDeclaration
import quartz.compiler.tree.misc.InlineC
import quartz.compiler.tree.misc.Typealias
import quartz.compiler.tree.struct.StructDeclaration
import quartz.compiler.util.Type

/**
 * Created by Aedan Smith.
 */

data class Program(
        val functionDeclarations: Map<String, FunctionDeclaration>,
        val externFunctionDeclarations: Map<String, ExternFunctionDeclaration>,
        val structDeclarations: Map<String, StructDeclaration>,
        val typealiasDeclarations: Map<String, Typealias>,
        val inlineCNodes: List<InlineC>
) {
    val symbolTable = generateSymbolTable()

    fun mapFnDeclarations(function: (FunctionDeclaration) -> FunctionDeclaration): Program {
        return Program(
                functionDeclarations.mapValues { function(it.value) },
                externFunctionDeclarations,
                structDeclarations,
                typealiasDeclarations,
                inlineCNodes
        )
    }

    fun mapExpressions(function: (Expression) -> Expression): Program {
        return Program(
                functionDeclarations.mapValues { it.value.mapExpressions(function) },
                externFunctionDeclarations,
                structDeclarations,
                typealiasDeclarations,
                inlineCNodes
        )
    }

    fun mapTypes(function: (Type?) -> Type?): Program {
        return Program(
                functionDeclarations.mapValues { it.value.mapTypes(function) },
                externFunctionDeclarations.mapValues { it.value.mapTypes(function) },
                structDeclarations.mapValues { it.value.mapTypes(function) },
                typealiasDeclarations.mapValues { it.value.mapTypes(function) },
                inlineCNodes
        )
    }

    override fun toString(): String {
        var s = ""
        functionDeclarations.forEach { s += it.value.toString() + "\n\n" }
        structDeclarations.forEach { s += it.value.toString() + "\n\n" }
        typealiasDeclarations.forEach { s += it.value.toString() + "\n\n" }
        return s
    }
}