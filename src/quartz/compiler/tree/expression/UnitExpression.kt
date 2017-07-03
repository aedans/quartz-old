package quartz.compiler.tree.expression

import quartz.compiler.errors.except
import quartz.compiler.semantics.types.VoidType
import quartz.compiler.tree.util.Type

/**
 * Created by Aedan Smith.
 */

abstract class UnitExpression : Expression {
    override val type = VoidType

    override fun withType(type: Type): Expression {
        if (type != VoidType)
            except { "Could not set type of $this to $type" }
        else return this
    }
}
