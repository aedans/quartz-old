package quartz.compiler.tokenizer.tokenizers

import quartz.compiler.tokenizer.Token
import quartz.compiler.tokenizer.TokenType
import quartz.compiler.util.misc.CharStream

/**
 * Created by Aedan Smith.
 */

val inlineCTokenizer = { src: CharStream ->
    if (src.peek() != '%') null
    else {
        src.next()
        var c = ""
        while (src.hasNext() && src.peek() != '%') {
            if (src.peek() == '\\') {
                src.next()
                c += src.next()
            } else {
                c += src.next()
            }
        }
        src.next()
        Token(TokenType.INLINE_C, c)
    }
}
