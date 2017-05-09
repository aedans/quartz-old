package quartz.compiler.tree.misc

import quartz.compiler.tree.GlobalDeclaration
import quartz.compiler.tree.function.Expression
import quartz.compiler.tree.function.Statement
import quartz.compiler.util.Type

/**
 * Created by Aedan Smith.
 */

open class InlineC(val src: String, override val type: Type? = null) : GlobalDeclaration, Statement, Expression {
    override val isLValue = true

    fun getExpressions(): List<Expression> {
        return listOf(this)
    }

    fun getStatements(): List<Statement> {
        return listOf(this)
    }

    override fun withType(type: Type?): Expression {
        return InlineC(src, type)
    }

    override fun toString(): String {
        return "InlineC"
    }
}
