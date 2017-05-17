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

        struct("__stdlib_div_t", "quot" to INT, "rem" to INT)
        newline()

        struct("__stdlib_ldiv_t", "quot" to LONG, "rem" to LONG)
        newline()

        externTypealias("wchar_t")
        _typealias(DIV, "__stdlib_div_t")
        _typealias(LDIV, "__stdlib_ldiv_t")

        newline()

        externVal("EXIT_FAILURE", INT)
        externVal("EXIT_SUCCESS", INT)
        externVal("RAND_MAX", INT)
        externVal("MB_CUR_MAX", INT)

        newline()

        externFunction("calloc", VOID.ptr(), SIZE, SIZE)
        externFunction("malloc", VOID.ptr(), SIZE)
        externFunction("realloc", VOID.ptr(), VOID.ptr(), SIZE)
        externFunction("free", null, VOID.ptr())

        newline()

        externFunction("atof", DOUBLE, STRING)
        externFunction("atoi", INT, STRING)
        externFunction("atol", LONG, STRING)
        externFunction("strtod", DOUBLE, STRING, CHAR.ptr().ptr())
        externFunction("strtol", LONG, STRING, CHAR.ptr().ptr(), INT)
        externFunction("stroul", ULONG, STRING, CHAR.ptr().ptr(), INT)
        externFunction("abort", null)
        externFunction("atexit", INT, "() -> $VOID")
        externFunction("exit", null, INT)
        externFunction("getenv", CHAR.ptr(), STRING)
        externFunction("system", INT, STRING)
        externFunction("bsearch", VOID.ptr(), VOID.const().ptr(), VOID.const().ptr(), SIZE, SIZE, INT.func(VOID.const().ptr(), VOID.const().ptr()))
        externFunction("qsort", VOID.ptr(), VOID.ptr(), SIZE, SIZE, INT.func(VOID.const().ptr(), VOID.const().ptr()))
        externFunction("abs", INT, INT)
        externFunction("div", DIV, INT, INT)
        externFunction("labs", LONG, LONG)
        externFunction("ldiv", LDIV, INT, INT)
        externFunction("rand", INT)
        externFunction("srand", null, INT)
        todo("mblen")
        todo("mbstowcs")
        todo("mbtowc")
        todo("wcstombs")
        todo("wctomb")
    }
}
