package quartz.compiler.generator.visitors.fndeclaration.expression

import quartz.compiler.generator.Visitor
import quartz.compiler.tree.ExpressionNode
import quartz.compiler.tree.expression.NumberLiteralNode

/**
 * Created by Aedan Smith.
 */

// TODO Escape characters
val numberLiteralVisitor: Visitor<ExpressionNode> = { numberLiteral, string, _ ->
    if (numberLiteral is NumberLiteralNode)
        string.append(numberLiteral.string)
}
