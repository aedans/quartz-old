package quartz.compiler.parser.parsers.fndeclaration.expression

import quartz.compiler.parser.Parser
import quartz.compiler.parser.verify
import quartz.compiler.parser.nodes.expression.NumberLiteralNode
import quartz.compiler.tokenizer.TokenType
import types.Primitives

/**
 * Created by Aedan Smith.
 */

val numberLiteralParser: Parser<NumberLiteralNode> = { tokens ->
    NumberLiteralNode(tokens.next().verify { it.equals(TokenType.NUMBER_LITERAL) }.value, Primitives.int)
}
