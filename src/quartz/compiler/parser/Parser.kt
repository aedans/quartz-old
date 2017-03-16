package quartz.compiler.parser

import quartz.compiler.tokenizer.TokenIterator

/**
 * Created by Aedan Smith.
 */

typealias Parser<T> = (TokenIterator, T) -> Boolean

inline fun <T : ParseNode> Iterable<Parser<T>>.parse(tokenIterator: TokenIterator, t: T, test: (TokenIterator) -> Boolean): T {
    loop@
    while (test(tokenIterator)) {
        @Suppress("LoopToCallChain")
        for (parser in this) {
            if (parser.invoke(tokenIterator, t)) {
                continue@loop
            }
        }
        invalidToken(tokenIterator.peek())
    }
    return t
}

fun <T : ParseNode> Iterable<Parser<T>>.parse(tokenIterator: TokenIterator, t: T, n: Int) {
    var i = 0
    parse(tokenIterator, t, { _ -> i++ < n })
}
