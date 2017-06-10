package quartz.compiler.tree.expression.expressions

import quartz.compiler.errors.QuartzException
import quartz.compiler.semantics.types.CharType
import quartz.compiler.semantics.types.ConstType
import quartz.compiler.semantics.types.PointerType
import quartz.compiler.tree.expression.Expression
import quartz.compiler.tree.util.Type

/**
 * Created by Aedan Smith.
 */

data class StringLiteral(val string: String) : Expression {
    override val isLValue = false
    override val type = ConstType(PointerType(CharType))

    override fun withType(type: Type): Expression {
        if (type == this.type)
            return this
        else
            throw QuartzException("Could not cast $this to $type")
    }

    override fun toString(): String {
        return "\"$string\""
    }
}
