package quartz.compiler.parser.parsers.statements

import quartz.compiler.parser.ParseNode
import quartz.compiler.parser.Parser
import quartz.compiler.parser.parse
import quartz.compiler.parser.parsers.statements.expressions.expressionParsers
import quartz.compiler.parser.parsers.parsenodes.ReturnNode
import quartz.compiler.tokenizer.TokenIterator
import quartz.compiler.tokenizer.TokenType

/**
 * Created by Aedan Smith.
 */

val returnParser: Parser<ParseNode> = {
    tokens: TokenIterator, superNode: ParseNode -> tokens.parse {
        if (!peek().equals(TokenType.KEYWORD, "return")) {
            false
        } else {
            next()

            val returnNode = ReturnNode()
            println("Found $returnNode")
            expressionParsers.parse(tokens, returnNode, 1)

            superNode.add(returnNode)

            true
        }
    }
}
