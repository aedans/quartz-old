package quartz.compiler.syntax.tree.program.function.expression

import quartz.compiler.syntax.tree.program.function.ExpressionNode
import quartz.compiler.util.Type
import quartz.compiler.util.types.Primitives
import quartz.compiler.util.types.QArray

/**
 * Created by Aedan Smith.
 */

class StringLiteralNode(val string: String) : ExpressionNode {
    override var type: Type? = QArray(Primitives.char)

    override fun toString(): String {
        return "\"$string\""
    }
}
