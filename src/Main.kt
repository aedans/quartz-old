
import quartz.compiler.Compiler
import quartz.compiler.errors.errorScope
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
        if (inFile.isFile){
            compile(args[0], args[1])
        } else {
            inFile.listFiles().forEach {
                println("Compiled in " + measureTimeMillis {
                    compile(it.absolutePath, File(args[1], it.nameWithoutExtension + ".c").absolutePath)
                } + "ms")
            }
        }
    } + "ms")
}

fun compile(inPath: String, outPath: String) {
    errorScope({ "file $inPath" }) {
        val inFile = File(inPath)
        val library = (inFile.parentFile?.let { Library.create(it) } ?: Library.LibraryPackage(".", File("."), emptyMap())) +
                Library.create(File(System.getenv()["QUARTZ_LIBRARY"]))
        val input = FileInputStream(inFile)
        val output = FileOutputStream(File(outPath))

        Compiler.compile(input, output, library)
    }
}
