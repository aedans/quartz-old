package quartz.compiler.semantics

import quartz.compiler.errors.QuartzException
import quartz.compiler.errors.errorScope
import quartz.compiler.tree.Program
import quartz.compiler.tree.function.FunctionDeclaration
import quartz.compiler.tree.function.expression.Identifier

/**
 * Created by Aedan Smith.
 */

fun Program.resolveFunctions(): Program {
    return errorScope({ "function resolver" }) {
        val newFunctionDeclarations = mutableMapOf<String, FunctionDeclaration>()
        functionDeclarations["main"]
                ?.resolveFunctions(this, newFunctionDeclarations)
                ?.also { newFunctionDeclarations.put(it.name, it) }
                ?: throw QuartzException("Could not find function main")
        copy(functionDeclarations = newFunctionDeclarations)
    }
}

fun FunctionDeclaration.resolveFunctions(
        program: Program,
        newFunctionDeclarations: MutableMap<String, FunctionDeclaration>
): FunctionDeclaration {
    return this.mapExpressions {
        if (it is Identifier) errorScope({ "identifier $it" }) {
            it.resolveFunction(program, newFunctionDeclarations)
        } else it
    }
}

fun Identifier.resolveFunction(program: Program, newFunctionDeclarations: MutableMap<String, FunctionDeclaration>): Identifier {
    val newFunction = resolveFunction(name, program) ?: return this

    if (!newFunctionDeclarations.contains(newFunction.name)) {
        newFunctionDeclarations.put(newFunction.name, newFunction)
        newFunctionDeclarations.put(newFunction.name, newFunction.resolveFunctions(program, newFunctionDeclarations))
    }

    return this.copy(name = newFunction.name)
}

fun resolveFunction(
        name: String,
        program: Program
): FunctionDeclaration? {
    return program.functionDeclarations[name]
}
