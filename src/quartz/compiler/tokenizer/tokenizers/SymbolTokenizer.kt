package quartz.compiler.tokenizer.tokenizers

import quartz.compiler.tokenizer.Token
import quartz.compiler.tokenizer.TokenType
import quartz.compiler.util.misc.CharStream

/**
 * Created by Aedan Smith.
 */

fun symbolTokenizer(vararg symbols: Char) = { src: CharStream ->
    var token: Token? = null
    @Suppress("LoopToCallChain")
    for (symbol in symbols) {
        if (src.peek() == symbol) {
            token = Token(TokenType.SYMBOL, symbol.toString())
        }
    }
    token?.apply { src.next() }
}
