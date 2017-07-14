package std.c

import util.*
import java.io.File

/**
 * Created by Aedan Smith.
 */

fun File.assert() {
    write("c/assert") {
        comment("Bindings for assert.h")
        newline()

        include("assert.h")
        newline()

        externFunction("assert", VOID.func(INT))
    }
}
