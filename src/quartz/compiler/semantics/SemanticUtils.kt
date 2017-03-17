package quartz.compiler.semantics

import quartz.compiler.tree.ExpressionNode
import quartz.compiler.tree.expression.CastNode
import quartz.compiler.util.Type

/**
 * Created by Aedan Smith.
 */

inline fun checkType(type: Type?, typeSetter: (Type) -> Unit,
                     expression: ExpressionNode, expressionSetter: (ExpressionNode) -> Unit,
                     message: () -> String) {
    val toType = expression.type ?: throw Exception(message())

    if (type == null) {
        typeSetter(toType)
    } else {
        if (!type.canCastTo(toType)) {
            throw Exception(message())
        } else if (type != toType) {
            expressionSetter(CastNode(type, expression))
        }
    }
}
