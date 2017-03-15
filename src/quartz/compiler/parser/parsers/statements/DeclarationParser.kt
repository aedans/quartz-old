package quartz.compiler.parser.parsers.statements

import quartz.compiler.parser.ParseNode
import quartz.compiler.parser.parse
import quartz.compiler.parser.parseType
import quartz.compiler.parser.parsers.expressionParsers
import quartz.compiler.parser.parsers.parsenodes.Declaration
import quartz.compiler.parser.verify
import quartz.compiler.tokenizer.TokenIterator
import quartz.compiler.tokenizer.TokenType
import quartz.compiler.util.ProtoType

/**
 * Created by Aedan Smith.
 */

val declarationParser = {
    tokens: TokenIterator, superNode: ParseNode -> tokens.parse {
        if (!peek().equals(TokenType.KEYWORD, "val") && !peek().equals(TokenType.KEYWORD, "var")) {
            false
        } else {
            val mutable = next().value == "var" // No need to double check
            val name = next().verify { it.equals(TokenType.IDENTIFIER) }.value
            val type: ProtoType? = if (peek().equals(TokenType.SYMBOL, ":")){
                next() // No need to double check
                parseType()
            } else { null }

            next().verify { it.equals(TokenType.OPERATOR, "=") }

            val declarationNode = Declaration(name, type, mutable)
            println("Found $declarationNode")

            expressionParsers.parse(tokens, declarationNode, 1)

            superNode.add(declarationNode)

            true
        }
    }
}
