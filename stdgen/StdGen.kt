
import std._default
import std.c.*
import java.io.File

/**
 * Created by Aedan Smith.
 */

fun main(args: Array<String>) {
    generate(File(args[0], "std"))
}

fun generate(file: File) {
    file.mkdir()

    File(file, "c").mkdir()
    file.assert()
    file.ctype()
    file.errno()
    file.inttypes()
    file.math()
    file.stddef()
    file.stdio()
    file.stdlib()
    file.stdint()
    file.time()

    file._default()
}
