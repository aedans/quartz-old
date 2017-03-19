
import quartz.compiler.Compiler
import java.io.File
import java.io.FileInputStream
import java.io.FileOutputStream
import java.io.PrintStream
import kotlin.system.measureTimeMillis

/**
 * Created by Aedan Smith.
 */

fun main(args: Array<String>) {
    val inFile = File(args[0])
    compile(inFile, args[1])
}

fun compile(inFile: File, outPath: String) {
    if (inFile.isDirectory) {
        inFile.listFiles().filter { it.extension == "qz" }.forEach {
            compile(it, outPath)
        }
    } else {
        val input = FileInputStream(inFile)
        val outFile = File(outPath, inFile.nameWithoutExtension + ".c")
        val output = PrintStream(FileOutputStream(outFile))

        var src = ""
        println("Compiled in " + measureTimeMillis {
            src = Compiler.compile(input)
        } + "ms\n")

        output.print(src)
    }
}
