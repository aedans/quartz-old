package quartz.compiler.parser.parsers.fndeclaration.statement

import quartz.compiler.parser.Parser
import quartz.compiler.tree.statement.IfNode
import quartz.compiler.parser.parse
import quartz.compiler.parser.parsers.fndeclaration.ExpressionParser
import quartz.compiler.parser.parsers.fndeclaration.StatementParser
import quartz.compiler.parser.verify
import quartz.compiler.tokenizer.TokenStream
import quartz.compiler.tokenizer.TokenType

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
            tokens.next().verify { it.equals(TokenType.SYMBOL, "{") }

            val ifNode = IfNode(test)

            println("Found $ifNode")

            loop@ while (!peek().equals(TokenType.SYMBOL, "}")) {
                ifNode.trueStatements.add(statementParser(tokens))
            }

            tokens.next()

            if (tokens.peek().equals(TokenType.KEYWORD, "else")) {
                tokens.next()

                tokens.next().verify { it.equals(TokenType.SYMBOL, "{") }

                loop@ while (!peek().equals(TokenType.SYMBOL, "}")) {
                    ifNode.falseStatements.add(statementParser(tokens))
                }

                tokens.next()
            }

            ifNode
        }
    }
}
