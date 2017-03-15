package quartz.compiler.parser.parsers.statements

import quartz.compiler.parser.ParseNode
import quartz.compiler.parser.parse
import quartz.compiler.parser.parsers.expressionParsers
import quartz.compiler.parser.parsers.parsenodes.Return
import quartz.compiler.tokenizer.TokenIterator
import quartz.compiler.tokenizer.TokenType

/**
 * Created by Aedan Smith.
 */

val returnParser = {
    tokens: TokenIterator, superNode: ParseNode -> tokens.parse {
        if (!peek().equals(TokenType.KEYWORD, "return")) {
            false
        } else {
            next()

            val returnNode = Return()
            println("Found $returnNode")
            expressionParsers.parse(tokens, returnNode, 1)

            superNode.add(returnNode)

            true
        }
    }
}
