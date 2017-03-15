package quartz.compiler.tokenizer.tokenizers

import quartz.compiler.tokenizer.Token
import quartz.compiler.tokenizer.TokenType
import quartz.compiler.util.misc.StringIterator

/**
 * Created by Aedan Smith.
 */

private val idchars = ('a'..'z') + ('A'..'Z') + ('0'..'9') + '_' + '-'
private val iidchars = ('a'..'z') + ('A'..'Z')+ '_'

// TODO Migrate keywords to parser
fun wordTokenizer(vararg keywords: String) = { src: StringIterator ->
    if (src.peek() !in iidchars) null
    else {
        var string = ""
        while (src.hasNext() && src.peek() in idchars){
            string += src.next()
        }
        if (keywords.contains(string)){
            Token(TokenType.KEYWORD, string)
        } else {
            Token(TokenType.IDENTIFIER, string)
        }
    }
}
