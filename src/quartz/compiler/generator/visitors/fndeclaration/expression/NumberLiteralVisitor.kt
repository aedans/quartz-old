package quartz.compiler.generator.visitors.fndeclaration.expression

import quartz.compiler.generator.Visitor
import quartz.compiler.syntax.tree.program.function.ExpressionNode
import quartz.compiler.syntax.tree.program.function.expression.NumberLiteralNode

/**
 * Created by Aedan Smith.
 */

// TODO Escape characters
val numberLiteralVisitor: Visitor<ExpressionNode> = { numberLiteral, string, _ ->
    if (numberLiteral is NumberLiteralNode)
        string.append(numberLiteral.string)
}
