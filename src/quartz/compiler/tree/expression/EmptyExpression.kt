package quartz.compiler.tree.expression

/**
 * Created by Aedan Smith.
 */

object EmptyExpression : UnitExpression() {
    override fun toString(): String {
        return "{}"
    }
}
