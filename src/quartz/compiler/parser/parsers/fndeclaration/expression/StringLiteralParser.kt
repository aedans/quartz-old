package quartz.compiler.parser.parsers.fndeclaration.expression

import quartz.compiler.parser.Parser
import quartz.compiler.tree.expression.StringLiteralNode
import quartz.compiler.parser.verify
import quartz.compiler.tokenizer.TokenType

/**
 * Created by Aedan Smith.
 */

val stringLiteralParser: Parser<StringLiteralNode> = { tokens ->
    StringLiteralNode(tokens.next().verify { it.equals(TokenType.STRING_LITERAL) }.value)
}
