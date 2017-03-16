package quartz.compiler.parser.parsers.expressions

import quartz.compiler.parser.ParseNode
import quartz.compiler.parser.Parser
import quartz.compiler.parser.parse
import quartz.compiler.parser.parsers.expressionParsers
import quartz.compiler.parser.parsers.parsenodes.FnCallNode
import quartz.compiler.tokenizer.TokenIterator
import quartz.compiler.tokenizer.TokenType

/**
 * Created by Aedan Smith.
 */

val fnCallParser: Parser = {
    tokens: TokenIterator, superNode: ParseNode -> tokens.parse {
        if (!hasNext(2) || !peek().equals(TokenType.IDENTIFIER) || !peek(1).equals(TokenType.SYMBOL, "(")) {
            false
        } else {
            val name = next().value // No need to double check
            next() // No need to double check
            val fnCallNode = FnCallNode(name)

            println("Found $fnCallNode")

            loop@
            while (true) {
                when {
                    peek().equals(TokenType.SYMBOL, ")") -> break@loop
                    peek().equals(TokenType.SYMBOL, ",") -> next() // No need to double check
                    else -> expressionParsers.parse(tokens, fnCallNode, 1)
                }
            }
            next() // No need to double check

            superNode.add(fnCallNode)

            true
        }
    }
}
