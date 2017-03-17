package quartz.compiler.parser.parsers.fndeclaration.statement

import quartz.compiler.parser.Parser
import quartz.compiler.parser.parse
import quartz.compiler.parser.parseBlock
import quartz.compiler.parser.parsers.fndeclaration.ExpressionParser
import quartz.compiler.parser.parsers.fndeclaration.StatementParser
import quartz.compiler.parser.verify
import quartz.compiler.tokenizer.TokenStream
import quartz.compiler.tokenizer.TokenType
import quartz.compiler.tree.statement.WhileNode

/**
 * Created by Aedan Smith.
 */

// TODO Single statement if statements
class WhileParser(val statementParser: StatementParser, val expressionParser: ExpressionParser) : Parser<WhileNode> {
    override fun invoke(tokens: TokenStream): WhileNode {
        return tokens.parse {
            tokens.next().verify { it.equals(TokenType.KEYWORD, "while") }
            tokens.next().verify { it.equals(TokenType.SYMBOL, "(") }

            val test = tokens.parse(expressionParser)

            tokens.next().verify { it.equals(TokenType.SYMBOL, ")") }

            val whileNode = WhileNode(test)

            println("Found $whileNode")

            whileNode.statements.addAll(parseBlock(statementParser))

            whileNode
        }
    }
}
