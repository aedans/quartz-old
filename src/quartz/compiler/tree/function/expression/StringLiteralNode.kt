package quartz.compiler.tree.function.expression

import quartz.compiler.exceptions.QuartzException
import quartz.compiler.semantics.types.ArrayType
import quartz.compiler.semantics.types.Primitives
import quartz.compiler.tree.function.ExpressionNode
import quartz.compiler.util.Type

/**
 * Created by Aedan Smith.
 */

class StringLiteralNode(val string: String) : ExpressionNode {
    override fun mapExpressions(function: (ExpressionNode) -> ExpressionNode): ExpressionNode {
        return this
    }

    override fun mapTypes(function: (Type?) -> Type?): ExpressionNode {
        return this
    }

    override val type = ArrayType(Primitives.char)

    override fun withType(type: Type?): ExpressionNode {
        if (type is ArrayType && type.type == Primitives.char)
            return this
        else
            throw QuartzException("Could not cast $this to $type")
    }

    override fun toString(): String {
        return "\"$string\""
    }
}
