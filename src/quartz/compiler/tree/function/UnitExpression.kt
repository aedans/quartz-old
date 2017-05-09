package quartz.compiler.tree.function

import quartz.compiler.errors.QuartzException
import quartz.compiler.semantics.types.VoidType
import quartz.compiler.util.Type

/**
 * Created by Aedan Smith.
 */

abstract class UnitExpression : Expression {
    override val type = VoidType
    override val isLValue: Boolean = false

    override fun withType(type: Type?): Expression {
        if (type != VoidType)
            throw QuartzException("Could not set type of $this to $type")
        else return this
    }
}
