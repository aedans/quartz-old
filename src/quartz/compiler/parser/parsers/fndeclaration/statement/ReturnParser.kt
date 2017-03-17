package quartz.compiler.parser.parsers.fndeclaration.statement

import quartz.compiler.parser.Parser
import quartz.compiler.tree.statement.ReturnNode
import quartz.compiler.parser.parse
import quartz.compiler.parser.parsers.fndeclaration.ExpressionParser
import quartz.compiler.parser.verify
import quartz.compiler.tokenizer.TokenStream
import quartz.compiler.tokenizer.TokenType

/**
 * Created by Aedan Smith.
 */

class ReturnParser(val expressionParser: ExpressionParser) : Parser<ReturnNode> {
    override fun invoke(tokens: TokenStream): ReturnNode {
        return tokens.parse {
            peek().verify { it.equals(TokenType.KEYWORD, "return") }

            next()

            val returnNode = ReturnNode(expressionParser(tokens))

            println("Found $returnNode")

            returnNode
        }
    }
}
