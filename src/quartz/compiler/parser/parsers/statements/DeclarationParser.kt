package quartz.compiler.parser.parsers.statements

import quartz.compiler.parser.*
import quartz.compiler.parser.parsers.statements.expressions.expressionParsers
import quartz.compiler.parser.parsers.parsenodes.VarDeclarationNode
import quartz.compiler.tokenizer.TokenIterator
import quartz.compiler.tokenizer.TokenType
import quartz.compiler.util.ProtoType

/**
 * Created by Aedan Smith.
 */

val declarationParser: Parser<ParseNode> = {
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

            next().verify { it.equals(TokenType.SYMBOL, "=") }

            val declarationNode = VarDeclarationNode(name, type, mutable)
            println("Found $declarationNode")

            expressionParsers.parse(tokens, declarationNode, 1)

            superNode.add(declarationNode)

            true
        }
    }
}
