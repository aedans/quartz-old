package quartz.compiler.syntax.builder.program.function

import quartz.compiler.parser.QuartzParser
import quartz.compiler.syntax.builder.program.function.statements.toNode
import quartz.compiler.syntax.builder.program.toNode
import quartz.compiler.syntax.tree.program.function.StatementNode

/**
 * Created by Aedan Smith.
 */

fun QuartzParser.StatementContext.toNode(): StatementNode {
    return if (inlineC() != null) {
        inlineC().toNode()
    } else if (returnStatement() != null) {
        returnStatement().toNode()
    } else if (varDeclaration() != null) {
        varDeclaration().toNode()
    } else if (ifStatement() != null) {
        ifStatement().toNode()
    } else if (whileLoop() != null) {
        whileLoop().toNode()
    } else if (prefixCallExpression() != null) {
        prefixCallExpression().toNode()
    } else if (infixCallExpression() != null) {
        infixCallExpression().toNode()
    } else {
        throw Exception("Error translating $this")
    }
}
