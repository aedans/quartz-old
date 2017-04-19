package quartz.compiler.tree.function.expression

import quartz.compiler.semantics.types.Primitives
import quartz.compiler.tree.function.Expression
import quartz.compiler.tree.function.Statement
import quartz.compiler.util.Type

/**
 * Created by Aedan Smith.
 */

class Sizeof(val sizeType: Type) : Expression {
    override val isLValue = false
    override val type = Primitives.long

    override fun getExpressions(): List<Expression> {
        return listOf(this)
    }

    override fun getStatements(): List<Statement> {
        return emptyList()
    }

    override fun mapExpressions(function: (Expression) -> Expression): Expression {
        return this
    }

    override fun mapStatements(function: (Statement) -> Statement): Expression {
        return this
    }

    override fun mapTypes(function: (Type?) -> Type?): Expression {
        return Sizeof(function(sizeType.mapTypes(function))!!)
    }

    override fun withType(type: Type?): Expression {
        return this
    }

    override fun toString(): String {
        return "sizeof($sizeType)"
    }
}
