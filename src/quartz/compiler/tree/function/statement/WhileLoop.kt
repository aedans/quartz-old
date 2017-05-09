package quartz.compiler.tree.function.statement

import quartz.compiler.tree.function.Expression
import quartz.compiler.tree.function.Statement
import quartz.compiler.util.times

/**
 * Created by Aedan Smith.
 */

class WhileLoop(val test: Expression, val block: Block) : Statement {
    override fun toString(): String {
        return "while ($test)"
    }

    override fun toString(i: Int): String {
        return "${("\t" * i)}$this {\n${block.toString(i+1)}${("\t" * i)}}"
    }
}
