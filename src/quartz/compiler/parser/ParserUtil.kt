package quartz.compiler.parser

import quartz.compiler.parser.parsers.fndeclaration.StatementParser
import quartz.compiler.tokenizer.Token
import quartz.compiler.tokenizer.TokenStream
import quartz.compiler.tokenizer.TokenType
import quartz.compiler.tree.StatementNode
import quartz.compiler.util.Type
import quartz.compiler.util.types.QArray
import types.Primitives


/**
 * Created by Aedan Smith.
 */

inline fun <reified T> TokenStream.parse(function: TokenStream.() -> T): T {
    return function()
}

fun invalidToken(token: Token): Nothing {
    throw ParseException("Unexpected token $token")
}

inline fun Token.verify(test: (Token) -> Boolean): Token {
    if (test(this)) {
        return this
    } else {
        invalidToken(this)
    }
}

fun TokenStream.parseType(): Type {
    var type = when (peek().value) {
        "char" -> Primitives.char
        "short" -> Primitives.short
        "int" -> Primitives.int
        "long" -> Primitives.long
        "float" -> Primitives.float
        "double" -> Primitives.double
        else -> throw Exception("Unrecognized type ${peek()}")
    }
    next()
    loop@ while (true) {
        when {
            peek().equals(TokenType.SYMBOL, "[") && peek(1).equals(TokenType.SYMBOL, "]") -> {
                type = QArray(type)
                next()
                next()
            }
            else -> break@loop
        }
    }
    return type
}

fun TokenStream.parseBlock(statementParser: StatementParser): List<StatementNode> {
    val statements = mutableListOf<StatementNode>()
    if (peek().equals(TokenType.SYMBOL, "{")) {
        next()

        loop@ while (!peek().equals(TokenType.SYMBOL, "}")) {
            statements.add(statementParser(this))
        }

        next()
    } else {
        statements.add(statementParser(this))
    }
    return statements
}
