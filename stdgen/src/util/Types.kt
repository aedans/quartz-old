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
    return "*$this"
}

fun Any?.func(vararg args: String): String {
    return (this?.toString() ?: VOID).func(*args)
}

fun String.func(vararg args: String, vararg: Boolean = false): String {
    return (if (args.isEmpty()) "()" else args.joinToString(prefix = "", postfix = "")) +
            (if (vararg) " ..." else "") +
            " -> $this"
}

fun String.paren(): String {
    return "($this)"
}

fun String.inlineC(): String {
    return "%%$this%%"
}
