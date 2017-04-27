package quartz.compiler.tree

import quartz.compiler.semantics.symboltable.generateSymbolTable
import quartz.compiler.tree.function.Expression
import quartz.compiler.tree.function.FunctionDeclaration
import quartz.compiler.tree.function.Statement
import quartz.compiler.tree.misc.ExternFunctionDeclaration
import quartz.compiler.tree.misc.InlineC
import quartz.compiler.tree.misc.TypealiasDeclaration
import quartz.compiler.tree.struct.StructDeclaration
import quartz.compiler.util.Type

/**
 * Created by Aedan Smith.
 */

data class Program(
        val functionDeclarations: Map<String, FunctionDeclaration>,
        val externFunctionDeclarations: Map<String, ExternFunctionDeclaration>,
        val structDeclarations: Map<String, StructDeclaration>,
        val typealiasDeclarationDeclarations: Map<String, TypealiasDeclaration>,
        val inlineCNodes: List<InlineC>
) {
    val symbolTable by lazy(this::generateSymbolTable)

    fun mapFunctionDeclarations(function: (FunctionDeclaration) -> FunctionDeclaration): Program {
        return copy(functionDeclarations = functionDeclarations.mapValues { function(it.value) })
    }

    fun mapStatements(function: (Statement) -> Statement): Program {
        return copy(functionDeclarations = functionDeclarations
                .mapValues { it.value.mapStatements { function(it.mapStatements(function)) } })
    }

    fun mapExpressions(function: (Expression) -> Expression): Program {
        return copy(functionDeclarations = functionDeclarations.mapValues { it.value.mapExpressions(function) })
    }

    fun mapTypes(function: (Type?) -> Type?): Program {
        return Program(
                functionDeclarations.mapValues { it.value.mapTypes(function) },
                externFunctionDeclarations.mapValues { it.value.mapTypes(function) },
                structDeclarations.mapValues { it.value.mapTypes(function) },
                typealiasDeclarationDeclarations.mapValues { it.value.mapTypes(function) },
                inlineCNodes
        )
    }

    override fun toString(): String {
        var s = ""
        functionDeclarations.forEach { s += it.value.toString() + "\n\n" }
        structDeclarations.forEach { s += it.value.toString() + "\n\n" }
        typealiasDeclarationDeclarations.forEach { s += it.value.toString() + "\n\n" }
        return s
    }
}