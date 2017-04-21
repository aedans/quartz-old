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
    val symbolTable by lazy {
        generateSymbolTable()
    }
    val destructorDeclarations by lazy {
        functionDeclarations.values.filter { it.name.startsWith("__destructor") }.map { it.name.substring(13) to it }.toMap()
    }

    fun mapFunctionDeclarations(function: (FunctionDeclaration) -> FunctionDeclaration): Program {
        return Program(
                functionDeclarations.mapValues { function(it.value) },
                externFunctionDeclarations,
                structDeclarations,
                typealiasDeclarationDeclarations,
                inlineCNodes
        )
    }

    fun mapStatements(function: (Statement) -> Statement): Program {
        return Program(
                functionDeclarations.mapValues { it.value.mapStatements { function(it.mapStatements(function)) } },
                externFunctionDeclarations,
                structDeclarations,
                typealiasDeclarationDeclarations,
                inlineCNodes
        )
    }

    fun mapExpressions(function: (Expression) -> Expression): Program {
        return Program(
                functionDeclarations.mapValues { it.value.mapExpressions(function) },
                externFunctionDeclarations,
                structDeclarations,
                typealiasDeclarationDeclarations,
                inlineCNodes
        )
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