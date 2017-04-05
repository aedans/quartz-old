package quartz.compiler.semantics

import quartz.compiler.exceptions.QuartzException
import quartz.compiler.semantics.types.FunctionType
import quartz.compiler.tree.Program
import quartz.compiler.tree.function.FnDeclaration
import quartz.compiler.tree.function.expression.Identifier
import quartz.compiler.tree.function.expression.MemberAccess
import quartz.compiler.tree.function.statement.FunctionCall
import quartz.compiler.util.Function
import quartz.compiler.util.Type

/**
 * Created by Aedan Smith.
 */

fun Program.resolveFunctionTemplates(): Program {
    val newFnDeclarations = mutableListOf<FnDeclaration>()
    newFnDeclarations.addAll(
        fnDeclarations.filterValues { it.function.templates.isEmpty() }.map {
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

private fun FnDeclaration.resolveFunctionTemplates(
        program: Program,
        newFnDeclarations: MutableList<FnDeclaration>
): FnDeclaration {
    return this.mapExpressions {
        when (it) {
            is FunctionCall -> it.resolveFunctionTemplates(program, newFnDeclarations)
            else -> it
        }
    }
}

private fun FunctionCall.resolveFunctionTemplates(
        program: Program,
        newFnDeclarations: MutableList<FnDeclaration>
): FunctionCall {
    if (templates.isEmpty())
        return this
    if (expression is MemberAccess)
        return resolveDotNotation(program.symbolTable).resolveFunctionTemplates(program, newFnDeclarations)
    if (expression !is Identifier)
        throw QuartzException("Templates are not allowed on variables")

    val newFunction = resolveFunctionTemplates(expression.name, templates, program, newFnDeclarations)

    return FunctionCall(
            Identifier(newFunction.name, FunctionType(newFunction.function)), emptyList(), expressions, type
    )
}

private fun resolveFunctionTemplates(
        name: String,
        types: List<Type>,
        program: Program,
        newFnDeclarations: MutableList<FnDeclaration>
): FnDeclaration {
    val newFunction = resolveFunctionTemplates(
            program.fnDeclarations[name] ?: throw QuartzException("Unknown function $name"),
            types,
            program,
            newFnDeclarations
    )
    newFnDeclarations.add(newFunction)
    return newFunction
}

private fun resolveFunctionTemplates(
        fnDeclaration: FnDeclaration,
        types: List<Type>,
        program: Program,
        newFnDeclarations: MutableList<FnDeclaration>
): FnDeclaration {
    val typeMap = fnDeclaration.function.templates.zip(types).toMap()
    var newName = fnDeclaration.name
    typeMap.forEach { newName += "_${it.value.descriptiveString}" }
    return FnDeclaration(
            newName,
            fnDeclaration.argNames,
            Function(
                    fnDeclaration.function.args,
                    emptyList(),
                    fnDeclaration.function.returnType,
                    fnDeclaration.function.vararg
            ),
            fnDeclaration.statements
    ).mapTypes { typeMap[it] ?: it }.resolveFunctionTemplates(program, newFnDeclarations)
}
