package quartz.compiler.tokenizer

import java.lang.NullPointerException
import java.util.*

/**
 * Created by Aedan Smith.
 */

class TokenIterator(inline val supplier: () -> Token?) {
    val stack = LinkedList<Token>()

    fun hasNext(i: Int = 1): Boolean {
        load(i)
        return stack.last != null
    }

    fun next(): Token {
        load(1)
        try { return stack.removeFirst()!! }
        catch (e: NullPointerException) {
            throw RuntimeException("Unexpected end of token stream.")
        }
    }

    fun peek(i: Int = 0): Token {
        load(i+1)
        try { return stack[i]!! }
        catch (e: NullPointerException) {
            throw RuntimeException("Unexpected end of token stream.")
        }
    }

    fun load(i: Int){
        while (stack.size < i) {
            stack.addLast(supplier.invoke())
        }
    }
}
