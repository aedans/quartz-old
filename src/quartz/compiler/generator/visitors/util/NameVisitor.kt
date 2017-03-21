package quartz.compiler.generator.visitors.util

/**
 * Created by Aedan Smith.
 */

private val VALID_CHAR_START = ('a'..'z') + ('A'..'Z') + '_'
private val VALID_CHAR = ('a'..'z') + ('A'..'Z') +('0'..'9') + '_'

fun String.visitName(string: StringBuilder) {
    var s = ""
    forEach {
        if (it in VALID_CHAR)
            s += it
        else
            s += it.toInt()
    }
    if (s[0] !in VALID_CHAR_START) {
        s = '_' + s
    }
    string.append(s)
}
