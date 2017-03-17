package quartz.compiler.parser.parsers.fndeclaration.statement

import quartz.compiler.parser.Parser
import quartz.compiler.parser.parse
import quartz.compiler.parser.parseBlock
import quartz.compiler.parser.parsers.fndeclaration.ExpressionParser
import quartz.compiler.parser.parsers.fndeclaration.StatementParser
import quartz.compiler.parser.verify
import quartz.compiler.tokenizer.TokenStream
import quartz.compiler.tokenizer.TokenType
import quartz.compiler.tree.statement.IfNode

/**
 * Created by Aedan Smith.
 */

// TODO Single statement if statements
// TODO If expressions
class IfParser(val statementParser: StatementParser, val expressionParser: ExpressionParser) : Parser<IfNode> {
    override fun invoke(tokens: TokenStream): IfNode {
        return tokens.parse {
            tokens.next().verify { it.equals(TokenType.KEYWORD, "if") }
            tokens.next().verify { it.equals(TokenType.SYMBOL, "(") }

            val test = tokens.parse(expressionParser)

            tokens.next().verify { it.equals(TokenType.SYMBOL, ")") }
            val ifNode = IfNode(test)

            println("Found $ifNode")

            ifNode.trueStatements.addAll(parseBlock(statementParser))

            if (tokens.peek().equals(TokenType.KEYWORD, "else")) {
                tokens.next()

                ifNode.falseStatements.addAll(parseBlock(statementParser))
            }

            ifNode
        }
    }
}
