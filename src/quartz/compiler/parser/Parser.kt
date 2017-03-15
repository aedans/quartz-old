package quartz.compiler.parser

import quartz.compiler.tokenizer.TokenIterator

/**
 * Created by Aedan Smith.
 */

typealias Parser = (TokenIterator, ParseNode) -> Boolean

inline fun <T : ParseNode> Iterable<Parser>.parse(tokenIterator: TokenIterator, parseNode: T, test: (TokenIterator) -> Boolean): T {
    loop@
    while (test(tokenIterator)) {
        @Suppress("LoopToCallChain")
        for (parser in this) {
            if (parser.invoke(tokenIterator, parseNode)) {
                continue@loop
            }
        }
        invalidToken(tokenIterator.peek())
    }
    return parseNode
}

fun Iterable<Parser>.parse(tokenIterator: TokenIterator, parseNode: ParseNode, n: Int) {
    var i = 0
    parse(tokenIterator, parseNode, { _ -> i++ < n })
}
