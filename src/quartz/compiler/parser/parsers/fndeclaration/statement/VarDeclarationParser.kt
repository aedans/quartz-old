package quartz.compiler.parser.parsers.fndeclaration.statement

import quartz.compiler.parser.Parser
import quartz.compiler.parser.parse
import quartz.compiler.parser.parseType
import quartz.compiler.parser.parsers.fndeclaration.ExpressionParser
import quartz.compiler.parser.verify
import quartz.compiler.util.Type
import quartz.compiler.parser.nodes.statement.VarDeclarationNode
import quartz.compiler.tokenizer.TokenStream
import quartz.compiler.tokenizer.TokenType

/**
 * Created by Aedan Smith.
 */

class VarDeclarationParser(val expressionParser: ExpressionParser) : Parser<VarDeclarationNode> {
    override fun invoke(tokens: TokenStream): VarDeclarationNode {
        return tokens.parse {
            peek().verify { it.equals(TokenType.KEYWORD, "val") || it.equals(TokenType.KEYWORD, "var") }

            val mutable = next().value == "var"
            val name = next().verify { it.equals(TokenType.IDENTIFIER) }.value
            val type: Type? = if (peek().equals(TokenType.SYMBOL, ":")) {
                next()
                parseType()
            } else {
                null
            }

            next().verify { it.equals(TokenType.SYMBOL, "=") }

            val declarationNode = VarDeclarationNode(name, type, mutable, expressionParser(tokens))

            println("Found $declarationNode")

            declarationNode
        }
    }
}

