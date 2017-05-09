package quartz.compiler.tree.function.statement

import quartz.compiler.tree.function.Expression
import quartz.compiler.tree.function.Statement
import quartz.compiler.util.times

/**
 * Created by Aedan Smith.
 */

class IfStatement(
        val test: Expression,
        val trueBlock: Block,
        val falseBlock: Block
) : Statement {
    override fun toString(): String {
        return "if ($test)"
    }

    override fun toString(i: Int): String {
        return "${"\t" * i}$this {\n${trueBlock.toString(i+1)}" +
                "${("\t" * i)}} else {" +
                if (falseBlock.statementList.isEmpty()) " }" else "\n${falseBlock.toString(i+1)}${"\t" * i}}"
    }
}
