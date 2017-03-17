package quartz.compiler.generator.visitors.fndeclaration.statement

import quartz.compiler.generator.Visitor
import quartz.compiler.parser.nodes.StatementNode
import quartz.compiler.parser.nodes.InlineCNode

/**
 * Created by Aedan Smith.
 */

val inlineCVisitor: Visitor<StatementNode> = { inlineC, string ->
    if (inlineC is InlineCNode)
        string.append(inlineC.src)
}
