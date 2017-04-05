
import quartz.compiler.Compiler
import quartz.compiler.tree.import.Library
import java.io.File
import java.io.FileInputStream
import java.io.FileOutputStream
import kotlin.system.measureTimeMillis

/**
 * Created by Aedan Smith.
 */

fun main(args: Array<String>) {
    println("Compiled in " + measureTimeMillis {
        val inFile = File(args[0])
        val library = (inFile.parentFile?.let { Library.create(it) } ?: Library.LibraryPackage("empty", emptyMap())) +
                Library.create(File(System.getenv()["QUARTZ_LIBRARY"]))
        val input = FileInputStream(inFile)
        val output = FileOutputStream(File(args[1]))

        Compiler.compile(input, output, library)
    } + "ms")
}
