package quartz.compiler.tree.expression

/**
 * Created by Aedan Smith.
 */

open class Block(val expressionList: List<Expression>) {
    override fun toString(): String {
        return "{ ${when {
            expressionList.isEmpty() -> ""
            expressionList.size == 1 -> expressionList.last().toString()
            else -> "... ${expressionList.last()}"
        }} }"
    }

    open fun toString(i: Int): String {
        var s = ""
        expressionList.forEach { s += "${it.toString(i)}\n" }
        return s
    }
}
