package quartz.compiler.syntax.nodes.enodes

import quartz.compiler.syntax.nodes.Expression
import quartz.compiler.syntax.type.types.Primitives
import quartz.compiler.syntax.type.types.QArray
import quartz.compiler.util.Type

/**
 * Created by Aedan Smith.
 */

class StringLiteral(val value: String) : Expression {
    override val evalType: Type = QArray(Primitives.char)

    override fun toString(): String {
        return "$value: $evalType"
    }

    override fun visit(builder: StringBuilder) {
        builder.append("\"$value\"")
    }
}
