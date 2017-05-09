package quartz.compiler.tree.function.expression

import quartz.compiler.errors.QuartzException
import quartz.compiler.semantics.types.FunctionType
import quartz.compiler.tree.function.Expression
import quartz.compiler.util.Function
import quartz.compiler.util.Type
import quartz.compiler.util.times

/**
 * Created by Aedan Smith.
 */

data class Lambda(
        val argNames: List<String>?,
        val function: Function,
        val block: BlockExpression
) : Expression {
    override val type = FunctionType(function)
    override val isLValue = false

    val argsWithNames: List<Pair<String, Type?>>? by lazy {
        when {
            argNames == null -> function.args?.mapIndexed{ i, it -> "p$i" to it }
            function.args == null -> null
            argNames.size != function.args.size -> throw QuartzException("$argNames.size != ${function.args}.size")
            else -> argNames.zip(function.args)
        }
    }

    override fun withType(type: Type?): Expression {
        return Lambda(argNames, (type as FunctionType).function, block)
    }

    override fun toString(): String {
        return "lambda ${type.function}"
    }

    override fun toString(i: Int): String {
        return "${"\t" * i}\n${block.toString(i+1)}"
    }
}
