package quartz.compiler.semantics.verifier

import quartz.compiler.syntax.tree.program.function.ExpressionNode
import quartz.compiler.syntax.tree.program.function.expression.CastNode
import quartz.compiler.util.Type

/**
 * Created by Aedan Smith.
 */

inline fun verifyType(type: Type?, typeSetter: (Type) -> Unit,
                      expression: ExpressionNode, expressionSetter: (ExpressionNode) -> Unit,
                      message: () -> String) {
    val toType = expression.type

    if (toType == null) {
        expressionSetter(CastNode(type, expression))
        return
    }

    if (type == null) {
        typeSetter(toType)
    } else {
        if (!type.canCastTo(toType)) {
            throw Exception(message() + " (${expression.type} -> $type)")
        } else if (type != toType) {
            expressionSetter(CastNode(type, expression))
        }
    }
}