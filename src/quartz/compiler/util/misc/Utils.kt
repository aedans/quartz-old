package quartz.compiler.util.misc

/**
 * Created by Aedan Smith.
 */

operator fun Char.times(i: Int): String {
    var string = ""
    for (j in 0 until i){
        string += this
    }
    return string
}

operator fun String.times(i: Int): String {
    var string = ""
    for (j in 0 until i){
        string += this
    }
    return string
}
