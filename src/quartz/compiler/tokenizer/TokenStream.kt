package quartz.compiler.tokenizer

import java.lang.NullPointerException
import java.util.*

/**
 * Created by Aedan Smith.
 */

class TokenStream(supplier: () -> Token?) {
    var index = 0
    private val stack = LazyStack(supplier)

    fun hasNext(i: Int = 1): Boolean {
        return stack[index + i] != null
    }

    fun next(): Token {
        try { return stack[index++]!! }
        catch (e: NullPointerException) {
            throw Exception("Unexpected end of token stream.")
        }
    }

    fun peek(i: Int = 0): Token {
        try { return stack[index + i]!! }
        catch (e: NullPointerException) {
            throw Exception("Unexpected end of token stream.")
        }
    }

    fun flush() {
        index = 0
        stack.clear()
    }

    private class LazyStack<out T>(inline val supplier: () -> T?) {
        private val content = Stack<T>()

        fun clear() {
            content.clear()
        }

        operator fun get(i: Int): T? {
            load(i)
            return content[i]
        }

        private fun load(i: Int) {
            while (content.size <= i) {
                content.add(supplier())
            }
        }
    }
}
