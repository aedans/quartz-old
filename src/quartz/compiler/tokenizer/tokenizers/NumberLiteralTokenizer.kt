package quartz.compiler.tokenizer.tokenizers

import quartz.compiler.tokenizer.Token
import quartz.compiler.tokenizer.TokenType
import quartz.compiler.util.misc.StringIterator

/**
 * Created by Aedan Smith.
 */

private val numbers = ('0'..'9') + '.'

// TODO Number formatting
val numberLiteralTokenizer = { src: StringIterator ->
    if (src.peek() !in numbers) null
    else {
        var number = ""
        while (src.hasNext() && src.peek() in numbers) {
            number += src.next()
        }
        Token(TokenType.NUMBER_LITERAL, number)
    }
}
