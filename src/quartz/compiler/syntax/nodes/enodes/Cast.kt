package quartz.compiler.syntax.nodes.enodes

import quartz.compiler.syntax.nodes.Expression
import quartz.compiler.util.Type

/**
 * Created by Aedan Smith.
 */

class Cast(val expression: Expression, override val evalType: Type) : Expression {
    override fun toString(): String {
        return "($evalType) ($expression)"
    }

    override fun visit(builder: StringBuilder) {
        builder.append("(")
        evalType.visit(builder)
        builder.append(") (")
        expression.visit(builder)
        builder.append(")")
    }
}
