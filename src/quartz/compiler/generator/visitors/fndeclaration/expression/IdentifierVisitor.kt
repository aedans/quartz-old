package quartz.compiler.generator.visitors.fndeclaration.expression

import quartz.compiler.generator.Visitor
import quartz.compiler.generator.visitors.util.nameVisitor
import quartz.compiler.syntax.tree.program.function.ExpressionNode
import quartz.compiler.syntax.tree.program.function.expression.IdentifierNode

/**
 * Created by Aedan Smith.
 */

val identifierVisitor: Visitor<ExpressionNode> = { identifier, string, depth ->
    if (identifier is IdentifierNode)
        nameVisitor(identifier.name, string, depth)
}
