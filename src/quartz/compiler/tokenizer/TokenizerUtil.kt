package quartz.compiler.tokenizer

import quartz.compiler.util.misc.StringIterator

/**
 * Created by Aedan Smith.
 */

fun Iterable<Tokenizer>.tokenize(src: StringIterator): TokenIterator {
    return TokenIterator {
        while (src.hasNext()) {
            @Suppress("LoopToCallChain")
            for (tokenizer in this) {
                val token = tokenizer.invoke(src)
                if (token != null) {
                    return@TokenIterator token
                }
            }
            src.next()
        }
        null
    }
}
