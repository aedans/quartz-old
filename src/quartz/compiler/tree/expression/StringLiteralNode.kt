package quartz.compiler.tree.expression

import quartz.compiler.tree.ExpressionNode
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