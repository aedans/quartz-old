package quartz.compiler.syntax.nodes.enodes

import quartz.compiler.syntax.nodes.Expression
import quartz.compiler.util.Type

/**
 * Created by Aedan Smith.
 */

class NumberLiteral(val value: String, override val evalType: Type) : Expression {
    override fun toString(): String {
        return "$value: $evalType"
    }

    override fun visit(builder: StringBuilder) {
        builder.append(value)
    }
}
