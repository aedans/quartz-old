package quartz.compiler.tree.function.statement

import quartz.compiler.tree.function.Statement

/**
 * Created by Aedan Smith.
 */

class Block(val statementList: List<Statement>) : Statement {
    override fun toString(): String {
        return "Block"
    }

    override fun toString(i: Int): String {
        var s = ""
        statementList.forEach { s += "${it.toString(i)}\n" }
        return s
    }
}
