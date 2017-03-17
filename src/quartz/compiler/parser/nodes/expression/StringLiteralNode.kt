package quartz.compiler.parser.nodes.expression

import quartz.compiler.parser.nodes.ExpressionNode
import quartz.compiler.util.Type
import quartz.compiler.util.types.QArray
import types.Primitives

/**
 * Created by Aedan Smith.
 */

class StringLiteralNode(val string: String) : ExpressionNode {
    override var type: Type? = QArray(Primitives.char)

    override fun toString(): String {
        return "\"$string\""
    }
}
