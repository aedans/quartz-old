package quartz.compiler.tree.function

import quartz.compiler.exceptions.QuartzException
import quartz.compiler.tree.GlobalDeclaration
import quartz.compiler.util.Function
import quartz.compiler.util.Type

/**
 * Created by Aedan Smith.
 */

class FnDeclaration(
        val name: String,
        val argNames: List<String>,
        val function: Function,
        val statements: List<Statement> = listOf()
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

    fun mapStatements(function: (Statement) -> Statement): FnDeclaration {
        return FnDeclaration(name, argNames, this.function, statements.map(function))
    }

    fun mapExpressions(function: (Expression) -> Expression): FnDeclaration {
        return mapStatements { it.mapExpressions(function) }
    }

    fun mapTypes(function: (Type?) -> Type?): FnDeclaration {
        return FnDeclaration(
                name,
                argNames,
                this.function.mapTypes(function),
                statements.map { it.mapTypes(function) }
        )
    }
}
