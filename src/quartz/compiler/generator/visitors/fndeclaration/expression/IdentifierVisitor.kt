package quartz.compiler.generator.visitors.fndeclaration.expression

import quartz.compiler.generator.Visitor
import quartz.compiler.generator.visitors.util.nameVisitor
import quartz.compiler.tree.ExpressionNode
import quartz.compiler.tree.expression.IdentifierNode

/**
 * Created by Aedan Smith.
 */

val identifierVisitor: Visitor<ExpressionNode> = { identifier, string, depth ->
    if (identifier is IdentifierNode)
        nameVisitor(identifier.name, string, depth)
}
