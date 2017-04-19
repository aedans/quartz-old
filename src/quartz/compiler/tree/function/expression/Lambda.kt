package quartz.compiler.tree.function.expression

import quartz.compiler.semantics.types.FunctionType
import quartz.compiler.tree.function.Expression
import quartz.compiler.tree.function.statement.Block
import quartz.compiler.util.Type
import quartz.compiler.util.times

/**
 * Created by Aedan Smith.
 */

class Lambda(
        val argNames: List<String>,
        override val type: FunctionType,
        val block: Block
) : Expression {
    override val isLValue = false

    override fun withType(type: Type?): Expression {
        return Lambda(argNames, type as FunctionType, block)
    }

    override fun getExpressions(): List<Expression> {
        return block.getExpressions()
    }

    override fun mapExpressions(function: (Expression) -> Expression): Expression {
        return Lambda(argNames, type, block.mapExpressions(function))
    }

    override fun mapTypes(function: (Type?) -> Type?): Expression {
        return Lambda(
                argNames,
                function(type.mapTypes(function)) as FunctionType,
                block.mapTypes(function)
        )
    }

    override fun toString(): String {
        return "${type.function} $block"
    }

    override fun toString(i: Int): String {
        return "${"|   " * i}\n${block.toString(i+1)}"
    }
}
