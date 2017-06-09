package std.c

import util.*
import java.io.File

/**
 * Created by Aedan Smith.
 */

val WCHAR = "wchar_t"
val SIZE = "size_t"
val PTRDIFF = "ptrdiff_t"

fun File.stddef() {
    write("c/stddef") {
        comment("Bindings for stddef.h")
        newline()

        include("stddef.h")
        newline()

        externTypealias(PTRDIFF)
        externTypealias(SIZE)
        externTypealias(WCHAR)

        newline()

        externVal("NULL", VOID.ptr())

        newline()

        todo("offsetof")
    }
}
