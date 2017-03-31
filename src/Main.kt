
import quartz.compiler.Compiler
import quartz.compiler.syntax.tree.import.Library
import java.io.File
import java.io.FileInputStream
import java.io.FileOutputStream
import java.io.PrintStream
import kotlin.system.measureTimeMillis

/**
 * Created by Aedan Smith.
 */

fun main(args: Array<String>) {
    println("Total time: " + measureTimeMillis {
        val inFile = File(args[0])
        val library = (inFile.parentFile?.let { Library.create(it) } ?: Library.LibraryPackage("empty", emptyMap())) +
                Library.create(File(System.getenv()["QUARTZ_LIBRARY"]))
        val input = FileInputStream(inFile)
        val output = PrintStream(FileOutputStream(File(args[1])))
        var src = ""

        println(library.toString(0))

        println("Compiled in " + measureTimeMillis {
            src = Compiler.compile(input, library)
        } + "ms\n")

        output.print(src)
    } + "ms")
}
