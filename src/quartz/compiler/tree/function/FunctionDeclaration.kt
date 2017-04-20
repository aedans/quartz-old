package quartz.compiler.tree.function

import quartz.compiler.errors.QuartzException
import quartz.compiler.tree.GlobalDeclaration
import quartz.compiler.tree.function.statement.Block
import quartz.compiler.util.Function
import quartz.compiler.util.Type

/**
 * Created by Aedan Smith.
 */

open class FunctionDeclaration(
        val name: String,
        val argNames: List<String>,
        val function: Function,
        val block: Block
) : GlobalDeclaration {
    val argsWithNames by lazy {
        if (argNames.size != function.args.size)
            throw QuartzException("$argNames.size != ${function.args}.size")
        argNames.zip(function.args)
    }

    override fun toString(): String {
        return "$name$function {\n${block.toString(1)}}"
    }

    fun getStatements(): List<Statement> {
        return block.getStatements()
    }

    fun mapStatements(function: (Statement) -> Statement): FunctionDeclaration {
        return FunctionDeclaration(name, argNames, this.function, block.mapStatements(function))
    }

    fun mapExpressions(function: (Expression) -> Expression): FunctionDeclaration {
        return FunctionDeclaration(name, argNames, this.function, block.mapExpressions(function))
    }

    fun mapTypes(function: (Type?) -> Type?): FunctionDeclaration {
        return FunctionDeclaration(
                name,
                argNames,
                this.function.mapTypes(function),
                block.mapTypes(function)
        )
    }
}
