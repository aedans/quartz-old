package std.c

import util.*
import java.io.File

/**
 * Created by Aedan Smith.
 */

val DIV = "div_t"
val LDIV = "ldiv_t"

fun File.stdlib() {
    write("c/stdlib") {
        comment("Bindings for stdlib.h")
        newline()

        import("std.c.stddef")
        newline()

        include("stdlib.h")
        newline()

        todo("struct div_t")
//        struct("__stdlib_div_t", "quot" to INT, "rem" to INT)
        _typealias("div_t", "div_t".inlineC())
        newline()

        todo("struct ldiv_t")
//        struct("__stdlib_ldiv_t", "quot" to LONG, "rem" to LONG)
        _typealias("ldiv_t", "ldiv_t".inlineC())
        newline()

        externTypealias("wchar_t")
//        _typealias(DIV, "__stdlib_div_t")
//        _typealias(LDIV, "__stdlib_ldiv_t")
//
//        newline()

        externVal("EXIT_FAILURE", INT)
        externVal("EXIT_SUCCESS", INT)
        externVal("RAND_MAX", INT)
        externVal("MB_CUR_MAX", INT)

        newline()

        externFunction("calloc", VOID.ptr().func(SIZE, SIZE))
        externFunction("malloc", VOID.ptr().func(SIZE))
        externFunction("realloc", VOID.ptr().func(VOID.ptr(), SIZE))
        externFunction("free", VOID.func(VOID.ptr()))

        newline()

        externFunction("atof", DOUBLE.func(STRING))
        externFunction("atoi", INT.func(STRING))
        externFunction("atol", LONG.func(STRING))
        externFunction("strtod", DOUBLE.func(STRING, CHAR.ptr().ptr()))
        externFunction("strtol", LONG.func(STRING, CHAR.ptr().ptr(), INT))
        externFunction("stroul", ULONG.func(STRING, CHAR.ptr().ptr(), INT))
        externFunction("abort", VOID.func())
        externFunction("atexit", INT.func(VOID.func()))
        externFunction("exit", VOID.func(INT))
        externFunction("getenv", CHAR.ptr().func(STRING))
        externFunction("system", INT.func(STRING))
        externFunction("bsearch", VOID.ptr().func(VOID.const().ptr(), VOID.const().ptr(), SIZE, SIZE, INT.func(VOID.const().ptr(), VOID.const().ptr()).paren()))
        externFunction("qsort", VOID.ptr().func(VOID.ptr(), SIZE, SIZE, INT.func(VOID.const().ptr(), VOID.const().ptr()).paren()))
        externFunction("abs", INT.func(INT))
        externFunction("div", DIV.func(INT, INT))
        externFunction("labs", LONG.func(LONG))
        externFunction("ldiv", LDIV.func(INT, INT))
        externFunction("rand", INT.func())
        externFunction("srand", VOID.func(INT))
        todo("mblen")
        todo("mbstowcs")
        todo("mbtowc")
        todo("wcstombs")
        todo("wctomb")
    }
}
