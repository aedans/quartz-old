package quartz.compiler.tree.function.statement

import quartz.compiler.tree.function.Expression
import quartz.compiler.tree.function.Statement

/**
 * Created by Aedan Smith.
 */

class ReturnStatement(val expression: Expression) : Statement {
    override fun toString(): String {
        return "return $expression"
    }
}
