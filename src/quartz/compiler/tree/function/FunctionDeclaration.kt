package quartz.compiler.tree.function

import quartz.compiler.exceptions.QuartzException
import quartz.compiler.tree.GlobalDeclaration
import quartz.compiler.util.Function
import quartz.compiler.util.Type

/**
 * Created by Aedan Smith.
 */

open class FunctionDeclaration(
        val name: String,
        val argNames: List<String>,
        val function: Function,
        val statements: List<Statement>
) : GlobalDeclaration {
    val argsWithNames by lazy {
        if (argNames.size != function.args.size)
            throw QuartzException("$argNames.size != ${function.args}.size")
        argNames.zip(function.args)
    }

    override fun toString(): String {
        var s = "$name$function"
        statements.forEach { s += '\n' + it.toString(1) }
        return s
    }

    fun mapStatements(function: (Statement) -> Statement): FunctionDeclaration {
        return FunctionDeclaration(name, argNames, this.function, statements.map { function(it.mapStatements(function)) })
    }

    fun mapExpressions(function: (Expression) -> Expression): FunctionDeclaration {
        return mapStatements { it.mapExpressions(function) }
    }

    fun mapTypes(function: (Type?) -> Type?): FunctionDeclaration {
        return FunctionDeclaration(
                name,
                argNames,
                this.function.mapTypes(function),
                statements.map { it.mapTypes(function) }
        )
    }
}
