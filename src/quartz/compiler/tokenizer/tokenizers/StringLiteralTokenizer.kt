package quartz.compiler.tokenizer.tokenizers

import quartz.compiler.tokenizer.Token
import quartz.compiler.tokenizer.TokenType
import quartz.compiler.util.misc.CharStream

/**
 * Created by Aedan Smith.
 */

// TODO String formatting
val stringLiteralTokenizer = { src: CharStream ->
    if (src.peek() != '\"') null
    else {
        src.next()
        var string = ""
        while (src.hasNext() && src.peek() != '\"') {
            string += src.next()
        }
        src.next()
        Token(TokenType.STRING_LITERAL, string)
    }
}
