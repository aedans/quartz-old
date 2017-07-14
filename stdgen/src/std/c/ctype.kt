package std.c

import util.*
import java.io.File

/**
 * Created by Aedan Smith.
 */

fun File.ctype() {
    write("c/ctype") {
        comment("Bindings for ctype.h")
        newline()

        include("ctype.h")
        newline()

        externFunction("isalnum", INT.func(INT))
        externFunction("isalpha", INT.func(INT))
        externFunction("iscnrtl", INT.func(INT))
        externFunction("isdigit", INT.func(INT))
        externFunction("isgraph", INT.func(INT))
        externFunction("islower", INT.func(INT))
        externFunction("isprint", INT.func(INT))
        externFunction("ispunct", INT.func(INT))
        externFunction("isspace", INT.func(INT))
        externFunction("isupper", INT.func(INT))
        externFunction("isxdigit", INT.func(INT))
        externFunction("tolower", INT.func(INT))
        externFunction("toupper", INT.func(INT))
    }
}
