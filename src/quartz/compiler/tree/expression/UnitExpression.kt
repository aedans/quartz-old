package quartz.compiler.tree.expression

import quartz.compiler.tree.Expression
import quartz.compiler.tree.types.VoidType

/**
 * Created by Aedan Smith.
 */

abstract class UnitExpression : Expression {
    override val type = VoidType
}
