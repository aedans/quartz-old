package quartz.compiler.generator.visitors.fndeclaration.statement

import quartz.compiler.generator.Visitor
import quartz.compiler.syntax.tree.program.InlineCNode
import quartz.compiler.syntax.tree.program.function.StatementNode

/**
 * Created by Aedan Smith.
 */

val inlineCVisitor: Visitor<StatementNode> = { inlineC, string, _ ->
    if (inlineC is InlineCNode)
        string.append(inlineC.src)
}
