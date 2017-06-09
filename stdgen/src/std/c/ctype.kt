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

        externFunction("isalnum", INT, INT)
        externFunction("isalpha", INT, INT)
        externFunction("iscnrtl", INT, INT)
        externFunction("isdigit", INT, INT)
        externFunction("isgraph", INT, INT)
        externFunction("islower", INT, INT)
        externFunction("isprint", INT, INT)
        externFunction("ispunct", INT, INT)
        externFunction("isspace", INT, INT)
        externFunction("isupper", INT, INT)
        externFunction("isxdigit", INT, INT)
        externFunction("tolower", INT, INT)
        externFunction("toupper", INT, INT)
    }
}
