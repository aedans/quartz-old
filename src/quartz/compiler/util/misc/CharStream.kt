package quartz.compiler.util.misc

/**
 * Created by Aedan Smith.
 */

// TODO Optimize
class CharStream(val src: String) {
    var index = 0

    fun hasNext(i: Int = 0): Boolean {
        return index + i < src.length
    }

    fun next(): Char {
        return try {
            src[index++]
        } catch (e: StringIndexOutOfBoundsException) {
            throw Exception("Unexpected end of program.")
        }
    }

    fun peek(i: Int = 0): Char {
        return try {
            src[index + i]
        } catch (e: StringIndexOutOfBoundsException) {
            throw Exception("Unexpected end of program.")
        }
    }
}
