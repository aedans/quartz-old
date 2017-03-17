package quartz.compiler.tokenizer

import quartz.compiler.util.misc.CharStream

/**
 * Created by Aedan Smith.
 */

fun Iterable<Tokenizer>.tokenize(src: CharStream): TokenStream {
    return TokenStream {
        while (src.hasNext()) {
            @Suppress("LoopToCallChain")
            for (tokenizer in this) {
                val token = tokenizer.invoke(src)
                if (token != null) {
                    return@TokenStream token
                }
            }
            src.next()
        }
        null
    }
}
