package quartz.compiler.syntax.nodes.snodes

import quartz.compiler.syntax.nodes.Expression
import quartz.compiler.syntax.nodes.Statement

/**
 * Created by Aedan Smith.
 */

class Return(val expression: Expression) : Statement {
    override fun toString(): String {
        return "return $expression"
    }

    override fun visit(builder: StringBuilder) {
        builder.append("return ")
        expression.visit(builder)
    }
}
