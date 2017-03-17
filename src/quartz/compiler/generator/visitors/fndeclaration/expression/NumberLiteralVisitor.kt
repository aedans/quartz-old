package quartz.compiler.generator.visitors.fndeclaration.expression

import quartz.compiler.generator.Visitor
import quartz.compiler.parser.nodes.ExpressionNode
import quartz.compiler.parser.nodes.expression.NumberLiteralNode

/**
 * Created by Aedan Smith.
 */

// TODO Escape characters
val numberLiteralVisitor: Visitor<ExpressionNode> = { numberLiteral, string ->
    if (numberLiteral is NumberLiteralNode)
        string.append(numberLiteral.string)
}
