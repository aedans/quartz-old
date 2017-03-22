package quartz.compiler.syntax.builder.program.function

import quartz.compiler.parser.QuartzParser
import quartz.compiler.syntax.builder.program.function.statements.toNode
import quartz.compiler.syntax.builder.program.misc.toNode
import quartz.compiler.syntax.tree.program.function.StatementNode

/**
 * Created by Aedan Smith.
 */

fun QuartzParser.StatementContext.toNode(): StatementNode {
    return when {
        inlineC() != null -> inlineC().toNode()
        returnStatement() != null -> returnStatement().toNode()
        varDeclaration() != null -> varDeclaration().toNode()
        ifStatement() != null -> ifStatement().toNode()
        whileLoop() != null -> whileLoop().toNode()
        prefixCallExpression() != null -> prefixCallExpression().toNode()
        infixCallExpression() != null -> infixCallExpression().toNode()
        else -> throw Exception("Error translating $text")
    }
}
