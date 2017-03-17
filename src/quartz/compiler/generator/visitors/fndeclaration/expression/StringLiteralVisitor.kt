package quartz.compiler.generator.visitors.fndeclaration.expression

import quartz.compiler.generator.Visitor
import quartz.compiler.tree.ExpressionNode
import quartz.compiler.tree.expression.StringLiteralNode

/**
 * Created by Aedan Smith.
 */

// TODO Escape characters
val stringLiteralVisitor: Visitor<ExpressionNode> = { stringLiteral, string, _ ->
    if (stringLiteral is StringLiteralNode) {
        string.append("\"${stringLiteral.string}\"")
    }
}
