package quartz.compiler.parser.parsers.fndeclaration.expression

import quartz.compiler.parser.Parser
import quartz.compiler.parser.verify
import quartz.compiler.parser.nodes.expression.IdentifierNode
import quartz.compiler.tokenizer.TokenType

/**
 * Created by Aedan Smith.
 */

val identifierParser: Parser<IdentifierNode> = { tokens ->
    IdentifierNode(tokens.next().verify { it.equals(TokenType.IDENTIFIER) }.value)
}
