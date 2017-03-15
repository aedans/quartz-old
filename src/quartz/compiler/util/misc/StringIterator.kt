package quartz.compiler.util.misc

/**
 * Created by Aedan Smith.
 */

class StringIterator(val src: String) {
    var index = 0

    fun hasNext(i: Int = 0) = index + i < src.length

    fun next() = try {
        src[index++]
    } catch (e: StringIndexOutOfBoundsException) {
        throw RuntimeException("Unexpected end of program.")
    }

    fun peek(i: Int = 0) = try {
        src[index + i]
    } catch (e: StringIndexOutOfBoundsException) {
        throw RuntimeException("Unexpected end of program.")
    }

    fun skip(i: Int = 1) {
        index += i
    }

    fun isNext(test: String): Boolean {
        if (!hasNext(test.length))
            return false
        test.forEachIndexed { i, c ->
            if (peek(i) != c) {
                return false
            }
        }
        return true
    }
}
