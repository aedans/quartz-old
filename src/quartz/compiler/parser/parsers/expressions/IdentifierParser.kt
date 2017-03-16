package quartz.compiler.parser.parsers.expressions

import quartz.compiler.parser.ParseNode
import quartz.compiler.parser.parse
import quartz.compiler.parser.parsers.parsenodes.IdentifierNode
import quartz.compiler.tokenizer.TokenIterator
import quartz.compiler.tokenizer.TokenType

/**
 * Created by Aedan Smith.
 */

val identifierParser = {
    tokens: TokenIterator, superNode: ParseNode -> tokens.parse {
        if (!peek().equals(TokenType.IDENTIFIER)) {
            false
        } else {
            val identifierNode = IdentifierNode(next().value)
            println("Found $identifierNode")
            superNode.add(identifierNode)
            true
        }
    }
}
