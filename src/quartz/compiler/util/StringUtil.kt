package quartz.compiler.util

/**
 * Created by Aedan Smith.
 */

operator fun String.times(i: Int): String {
    var s = ""
    for (j in 0 until i) {
        s += this
    }
    return s
}
