package quartz.compiler.parser.parsers.fndeclaration.statement

import quartz.compiler.parser.Parser
import quartz.compiler.parser.nodes.ExpressionNode
import quartz.compiler.parser.nodes.statement.FnCallNode
import quartz.compiler.parser.parse
import quartz.compiler.parser.parsers.fndeclaration.ExpressionParser
import quartz.compiler.parser.verify
import quartz.compiler.tokenizer.TokenStream
import quartz.compiler.tokenizer.TokenType

/**
 * Created by Aedan Smith.
 */

class FnCallParser(val expressionParser: ExpressionParser): Parser<FnCallNode> {
    override fun invoke(tokens: TokenStream): FnCallNode {
        return tokens.parse {
            val name = next().verify { it.equals(TokenType.IDENTIFIER) }.value
            next().verify { it.equals(TokenType.SYMBOL, "(") }

            val expressions = mutableListOf<ExpressionNode>()

            loop@
            while (true) {
                when {
                    peek().equals(TokenType.SYMBOL, ")") -> break@loop
                    peek().equals(TokenType.SYMBOL, ",") -> next()
                    else -> expressions.add(expressionParser(tokens))
                }
            }

            next()

            FnCallNode(name, expressions)
        }
    }
}
