package quartz.compiler.parser

import quartz.compiler.tokenizer.Token
import quartz.compiler.tokenizer.TokenStream
import quartz.compiler.tokenizer.TokenType
import quartz.compiler.util.Type
import quartz.compiler.util.types.QArray
import types.Primitives
import java.util.*


/**
 * Created by Aedan Smith.
 */

inline fun <reified T> TokenStream.parse(function: TokenStream.() -> T): T {
    return function()
}

fun invalidToken(token: Token, vararg expected: Token): Nothing {
    if (expected.isEmpty())
        throw ParseException("Unexpected token $token")
    else {
        throw ParseException("Unexpected token $token, expected ${Arrays.toString(expected)}")
    }
}

inline fun Token.verify(test: (Token) -> Boolean): Token {
    if (test(this)) {
        return this
    } else {
        invalidToken(this)
    }
}

// TODO
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
