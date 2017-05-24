package quartz.compiler.tree.function.expression

import quartz.compiler.tree.function.Expression
import quartz.compiler.tree.function.UnitExpression
import quartz.compiler.util.times

/**
 * Created by Aedan Smith.
 */

data class WhileExpression(val condition: Expression, val block: BlockExpression) : UnitExpression() {
    override fun toString(): String {
        return "while ($condition)"
    }

    override fun toString(i: Int): String {
        return "${("\t" * i)}$this {\n${block.toString(i+1)}${("\t" * i)}}"
    }
}
