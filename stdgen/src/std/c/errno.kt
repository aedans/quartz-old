package std.c

import util.*
import java.io.File

/**
 * Created by Aedan Smith.
 */

fun File.errno() {
    write("c/errno") {
        comment("Bindings for errno.h")
        newline()

        include("errno.h")
        newline()

        externVar("errno", INT)
        externVal("EDOM", INT)
        externVal("ERANGE", INT)
    }
}
