package quartz.compiler.parser.parsers.statements.expressions

import quartz.compiler.parser.*
import quartz.compiler.parser.parsers.parsenodes.CastNode
import quartz.compiler.tokenizer.TokenIterator
import quartz.compiler.tokenizer.TokenType

/**
 * Created by Aedan Smith.
 */

val castParser: Parser<ParseNode> = {
    tokens: TokenIterator, superNode: ParseNode -> tokens.parse {
        if (!peek().equals(TokenType.SYMBOL, "(")) {
            false
        } else {
            next() // No need to double check
            val type = parseType()
            next().verify { it.equals(TokenType.SYMBOL, ")") }
            val castNode = CastNode(type)
            println("Found $castNode")

            expressionParsers.parse(tokens, castNode, 1)

            superNode.add(castNode)

            true
        }
    }
}