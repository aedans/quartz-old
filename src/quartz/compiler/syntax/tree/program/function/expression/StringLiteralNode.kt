package quartz.compiler.syntax.tree.program.function.expression

import quartz.compiler.syntax.tree.program.function.ExpressionNode
import quartz.compiler.util.Type
import quartz.compiler.util.types.ArrayType
import quartz.compiler.util.types.Primitives

/**
 * Created by Aedan Smith.
 */

class StringLiteralNode(val string: String) : ExpressionNode {
    override val type = ArrayType(Primitives.char)

    override fun withType(type: Type?): ExpressionNode {
        if (type is ArrayType && type.type == Primitives.char)
            return this
        else
            throw Exception("Could not cast $this to $type")
    }

    override fun toString(): String {
        return "\"$string\""
    }
}
