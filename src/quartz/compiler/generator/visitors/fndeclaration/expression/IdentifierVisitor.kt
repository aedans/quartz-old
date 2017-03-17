package quartz.compiler.generator.visitors.fndeclaration.expression

import quartz.compiler.generator.Visitor
import quartz.compiler.generator.visitors.util.nameVisitor
import quartz.compiler.parser.nodes.ExpressionNode
import quartz.compiler.parser.nodes.expression.IdentifierNode

/**
 * Created by Aedan Smith.
 */

val identifierVisitor: Visitor<ExpressionNode> = { identifier, string ->
    if (identifier is IdentifierNode)
        nameVisitor(identifier.name, string)
}
