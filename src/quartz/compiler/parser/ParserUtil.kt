package quartz.compiler.parser

import quartz.compiler.syntax.type.toType
import quartz.compiler.syntax.type.types.QArray
import quartz.compiler.tokenizer.Token
import quartz.compiler.tokenizer.TokenIterator
import quartz.compiler.tokenizer.TokenType
import quartz.compiler.util.ProtoType


/**
 * Created by Aedan Smith.
 */

inline fun <T> TokenIterator.parse(function: TokenIterator.() -> T): T {
    return function()
}

fun invalidToken(token: Token): Nothing {
    throw RuntimeException("Unexpected token $token")
}

inline fun Token.verify(test: (Token) -> Boolean): Token {
    if (test(this)) {
        return this
    } else {
        invalidToken(this)
    }
}

fun TokenIterator.parseType(): ProtoType {
    return parse {
        val typeID = next().verify { it.equals(TokenType.IDENTIFIER) }.value
        var type: ProtoType = ProtoType(typeID) { typeID.toType() }
        loop@
        while (true) {
            when {
                peek(0).equals(TokenType.SYMBOL, "[") && peek(1).equals(TokenType.SYMBOL, "]") -> {
                    next() // No need to double check
                    next() // No need to double check
                    type = ArrayProtoType(type)
                }
                else -> break@loop
            }
        }
        type
    }
}

private class ArrayProtoType(val type: ProtoType) : ProtoType("$type[]", { QArray(type.toType()) })

