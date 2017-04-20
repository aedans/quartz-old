package quartz.compiler.semantics

import quartz.compiler.errors.QuartzException
import quartz.compiler.errors.errorScope
import quartz.compiler.semantics.types.FunctionType
import quartz.compiler.tree.Program
import quartz.compiler.tree.function.FunctionDeclaration
import quartz.compiler.tree.function.Statement
import quartz.compiler.tree.function.expression.Identifier
import quartz.compiler.tree.function.expression.MemberAccess
import quartz.compiler.tree.function.statement.Delete
import quartz.compiler.tree.function.statement.FunctionCall
import quartz.compiler.util.Function
import quartz.compiler.util.Type

/**
 * Created by Aedan Smith.
 */

fun Program.resolveFunctionTemplates(): Program {
    return errorScope({ "function template resolver" }) {
        val newFunctionDeclarations = mutableMapOf<String, FunctionDeclaration>()
        functionDeclarations.filterValues { it.function.templates.isEmpty() }.forEach {
            it.value.resolveFunctionTemplates(this, newFunctionDeclarations).also { newFunctionDeclarations.put(it.name, it) }
        }
        Program(
                newFunctionDeclarations,
                externFunctionDeclarations,
                structDeclarations,
                typealiasDeclarationDeclarations,
                inlineCNodes
        )
    }
}

private fun FunctionDeclaration.resolveFunctionTemplates(
        program: Program,
        newFunctionDeclarations: MutableMap<String, FunctionDeclaration>
): FunctionDeclaration {
    return this.mapExpressions {
        when (it) {
            is FunctionCall -> errorScope({ "function call $it" }) {
                it.resolveFunctionTemplates(program, newFunctionDeclarations)
            }
            else -> it
        }
    }.mapStatements {
        when (it) {
            is Delete -> errorScope({ "delete $it" }) {
                it.resolveFunctionTemplates(program, newFunctionDeclarations)
            }
            else -> it
        }
    }
}

private fun Delete.resolveFunctionTemplates(program: Program, newFunctionDeclarations: MutableMap<String, FunctionDeclaration>): Statement {
    val resolved = this.resolve(program.destructorDeclarations)
    return when (resolved) {
        is FunctionCall -> resolved.resolveFunctionTemplates(program, newFunctionDeclarations)
        else -> this
    }
}

private fun FunctionCall.resolveFunctionTemplates(
        program: Program,
        newFunctionDeclarations: MutableMap<String, FunctionDeclaration>
): FunctionCall {
    if (templates.isEmpty())
        return this
    if (expression is MemberAccess)
        return resolveDotNotation(program.symbolTable).resolveFunctionTemplates(program, newFunctionDeclarations)
    if (expression !is Identifier)
        throw QuartzException("Templates are not allowed on variables")

    val newFunction = resolveFunctionTemplates(expression.name, templates, program, newFunctionDeclarations)

    return FunctionCall(
            Identifier(newFunction.name, FunctionType(newFunction.function)), emptyList(), args, type
    )
}

private fun resolveFunctionTemplates(
        name: String,
        types: List<Type>,
        program: Program,
        newFunctionDeclarations: MutableMap<String, FunctionDeclaration>
): FunctionDeclaration {
    return errorScope({ "function template resolver $name" }) {
        val functionDeclaration = program.functionDeclarations[name] ?: throw QuartzException("Could not find function with name $name")
        val typeMap = functionDeclaration.function.templates.zip(types).toMap()
        var newName = "__${functionDeclaration.name}"
        typeMap.forEach { newName += "_${it.value.descriptiveString}" }
        if (!newFunctionDeclarations.containsKey(newName)) {
            newFunctionDeclarations.put(newName, FunctionDeclaration(
                    newName,
                    functionDeclaration.argNames,
                    Function(
                            functionDeclaration.function.args,
                            emptyList(),
                            functionDeclaration.function.returnType,
                            functionDeclaration.function.vararg
                    ),
                    functionDeclaration.block
            ).mapTypes { typeMap[it] ?: it })
            newFunctionDeclarations.put(newName, newFunctionDeclarations[newName]!!
                    .resolveFunctionTemplates(program, newFunctionDeclarations))
        }
        newFunctionDeclarations[newName]!!
    }
}
