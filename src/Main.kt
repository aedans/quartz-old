
import quartz.compiler.Compiler
import java.io.File
import java.io.FileOutputStream
import java.io.FileReader
import java.io.PrintStream
import kotlin.system.measureTimeMillis

/**
 * Created by Aedan Smith.
 */

fun main(args: Array<String>) {
    val inFile = File(args[0])
    val outFile = File(args[1])
    val input = FileReader(inFile).readText()
    val output = PrintStream(FileOutputStream(File(outFile, inFile.nameWithoutExtension + ".c")))

    var src = ""
    println("Compiled in " + measureTimeMillis {
        src = Compiler(input).compile()
    } + "ms")

    output.print(src)
}
