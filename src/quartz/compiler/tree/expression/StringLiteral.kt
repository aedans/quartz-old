package quartz.compiler.tree.expression

import quartz.compiler.tree.Expression
import quartz.compiler.tree.types.CharType
import quartz.compiler.tree.types.ConstType
import quartz.compiler.tree.types.PointerType

/**
 * Created by Aedan Smith.
 */

data class StringLiteral(val string: String) : Expression {
    override val type = ConstType(PointerType(CharType))

    override fun toString(): String {
        return "\"$string\""
    }
}
