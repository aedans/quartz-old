package quartz.compiler.parser.parsers.expressions

import quartz.compiler.parser.ParseNode
import quartz.compiler.parser.parse
import quartz.compiler.parser.parsers.parsenodes.StringLiteralNode
import quartz.compiler.tokenizer.TokenIterator
import quartz.compiler.tokenizer.TokenType

/**
 * Created by Aedan Smith.
 */

val stringParser = {
    tokens: TokenIterator, superNode: ParseNode -> tokens.parse {
        if (!peek().equals(TokenType.STRING_LITERAL)) {
            false
        } else {
            val stringNode = StringLiteralNode(next().value)
            println("Found $stringNode")
            superNode.add(stringNode)
            true
        }
    }
}
