package quartz.compiler.semantics

import quartz.compiler.exceptions.QuartzException
import quartz.compiler.semantics.types.FunctionType
import quartz.compiler.tree.Program
import quartz.compiler.tree.function.FunctionDeclaration
import quartz.compiler.tree.function.expression.Identifier
import quartz.compiler.tree.function.expression.MemberAccess
import quartz.compiler.tree.function.statement.FunctionCall
import quartz.compiler.util.Function
import quartz.compiler.util.Type

/**
 * Created by Aedan Smith.
 */

fun Program.resolveFunctionTemplates(): Program {
    val newFnDeclarations = mutableListOf<FunctionDeclaration>()
    newFnDeclarations.addAll(
        functionDeclarations.filterValues { it.function.templates.isEmpty() }.map {
            it.value.resolveFunctionTemplates(this, newFnDeclarations)
        }
    )
    return Program(
            newFnDeclarations.map { it.name to it }.toMap(),
            externFunctionDeclarations,
            structDeclarations,
            typealiasDeclarations,
            inlineCNodes
    )
}

private fun FunctionDeclaration.resolveFunctionTemplates(
        program: Program,
        newFunctionDeclarations: MutableList<FunctionDeclaration>
): FunctionDeclaration {
    return this.mapExpressions {
        when (it) {
            is FunctionCall -> it.resolveFunctionTemplates(program, newFunctionDeclarations)
            else -> it
        }
    }
}

private fun FunctionCall.resolveFunctionTemplates(
        program: Program,
        newFunctionDeclarations: MutableList<FunctionDeclaration>
): FunctionCall {
    if (templates.isEmpty())
        return this
    if (expression is MemberAccess)
        return resolveDotNotation(program.symbolTable).resolveFunctionTemplates(program, newFunctionDeclarations)
    if (expression !is Identifier)
        throw QuartzException("Templates are not allowed on variables")

    val newFunction = resolveFunctionTemplates(expression.name, templates, program, newFunctionDeclarations)

    return FunctionCall(
            Identifier(newFunction.name, FunctionType(newFunction.function)), emptyList(), expressions, type
    )
}

private fun resolveFunctionTemplates(
        name: String,
        types: List<Type>,
        program: Program,
        newFunctionDeclarations: MutableList<FunctionDeclaration>
): FunctionDeclaration {
    val newFunction = resolveFunctionTemplates(
            program.functionDeclarations[name] ?: throw QuartzException("Unknown function $name"),
            types,
            program,
            newFunctionDeclarations
    )
    newFunctionDeclarations.add(newFunction)
    return newFunction
}

private fun resolveFunctionTemplates(
        functionDeclaration: FunctionDeclaration,
        types: List<Type>,
        program: Program,
        newFunctionDeclarations: MutableList<FunctionDeclaration>
): FunctionDeclaration {
    val typeMap = functionDeclaration.function.templates.zip(types).toMap()
    var newName = functionDeclaration.name
    typeMap.forEach { newName += "_${it.value.descriptiveString}" }
    return FunctionDeclaration(
            newName,
            functionDeclaration.argNames,
            Function(
                    functionDeclaration.function.args,
                    emptyList(),
                    functionDeclaration.function.returnType,
                    functionDeclaration.function.vararg
            ),
            functionDeclaration.statements
    ).mapTypes { typeMap[it] ?: it }.resolveFunctionTemplates(program, newFunctionDeclarations)
}
