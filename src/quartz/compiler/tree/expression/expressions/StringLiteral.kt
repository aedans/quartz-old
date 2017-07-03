package quartz.compiler.tree.expression.expressions

import quartz.compiler.semantics.types.CharType
import quartz.compiler.semantics.types.ConstType
import quartz.compiler.semantics.types.PointerType
import quartz.compiler.tree.expression.Expression

/**
 * Created by Aedan Smith.
 */

data class StringLiteral(val string: String) : Expression {
    override val type = ConstType(PointerType(CharType))

    override fun toString(): String {
        return "\"$string\""
    }
}
