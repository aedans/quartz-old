package util

/**
 * Created by Aedan Smith.
 */

val CHAR = "char"
val INT = "int"
val LONG = "long"
val ULONG = "ulong"
val DOUBLE = "double"
val VOID = "void"

val STRING = CHAR.const().ptr()

fun String.const(): String {
    return "const $this"
}

fun String.ptr(): String {
    return "$this*"
}

fun String?.func(vararg args: String): String {
    return args.joinToString(prefix = "(", postfix = ")") + (if (this != null) " -> $this" else "")
}

fun String.inlineC(): String {
    return "%%$this%%"
}
