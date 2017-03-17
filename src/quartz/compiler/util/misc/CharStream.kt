package quartz.compiler.util.misc

/**
 * Created by Aedan Smith.
 */

// TODO Optimize
class CharStream(val src: String) {
    var index = 0

    fun hasNext(): Boolean {
        return index < src.length
    }

    fun next(): Char {
        return try {
            src[index++]
        } catch (e: StringIndexOutOfBoundsException) {
            throw Exception("Unexpected end of program.")
        }
    }

    fun peek(): Char {
        return try {
            src[index]
        } catch (e: StringIndexOutOfBoundsException) {
            throw Exception("Unexpected end of program.")
        }
    }
}
