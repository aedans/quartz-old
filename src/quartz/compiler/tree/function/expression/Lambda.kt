package quartz.compiler.tree.function.expression

import quartz.compiler.exceptions.QuartzException
import quartz.compiler.semantics.types.FunctionType
import quartz.compiler.tree.function.Expression
import quartz.compiler.tree.function.Statement
import quartz.compiler.tree.function.statement.Block
import quartz.compiler.util.Function
import quartz.compiler.util.Type
import quartz.compiler.util.times

/**
 * Created by Aedan Smith.
 */

class Lambda(
        val argNames: List<String>,
        val function: Function,
        val block: Block
) : Expression {
    override val type = FunctionType(function)
    override val isLValue = false

    val argsWithNames by lazy {
        if (argNames.size != function.args.size)
            throw QuartzException("$argNames.size != ${function.args}.size")
        argNames.zip(function.args)
    }

    override fun getExpressions(): List<Expression> {
        return block.getExpressions()
    }

    override fun getStatements(): List<Statement> {
        return emptyList()
    }

    override fun mapExpressions(function: (Expression) -> Expression): Expression {
        return Lambda(argNames, this.function, block.mapExpressions(function))
    }

    override fun mapStatements(function: (Statement) -> Statement): Expression {
        return Lambda(argNames, this.function, block.mapStatements(function))
    }

    override fun mapTypes(function: (Type?) -> Type?): Expression {
        return Lambda(
                argNames,
                this.function.mapTypes(function),
                block.mapTypes(function)
        )
    }

    override fun withType(type: Type?): Expression {
        return Lambda(argNames, (type as FunctionType).function, block)
    }

    override fun toString(): String {
        return "${type.function} $block"
    }

    override fun toString(i: Int): String {
        return "${"|   " * i}\n${block.toString(i+1)}"
    }
}
