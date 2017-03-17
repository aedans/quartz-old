package quartz.compiler.generator.visitors.fndeclaration.expression

import quartz.compiler.generator.Visitor
import quartz.compiler.parser.nodes.ExpressionNode
import quartz.compiler.parser.nodes.expression.StringLiteralNode

/**
 * Created by Aedan Smith.
 */

// TODO Escape characters
val stringLiteralVisitor: Visitor<ExpressionNode> = { stringLiteral, string ->
    if (stringLiteral is StringLiteralNode) {
        string.append("\"${stringLiteral.string}\"")
    }
}
