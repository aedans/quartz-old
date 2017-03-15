package quartz.compiler.tokenizer.tokenizers

import quartz.compiler.tokenizer.Token
import quartz.compiler.tokenizer.TokenType
import quartz.compiler.tokenizer.Tokenizer
import quartz.compiler.util.misc.StringIterator

/**
 * Created by Aedan Smith.
 */

fun operatorTokenizer(vararg operators: String): Tokenizer = { src: StringIterator ->
    var token: Token? = null
    operators.forEach {
        if (src.isNext(it)) {
            token = Token(TokenType.OPERATOR, it)
        }
    }
    token?.apply { src.skip(value.length) }
}
