
import java.io.File
import java.io.OutputStream

/**
 * Created by Aedan Smith.
 */

fun main(args: Array<String>) {
    val tests = File(args[0], "tests")
    val expected = File(args[0], "expected")
    val src = File(args[0], "src").empty()
    val exe = File(args[0], "exe").empty()
    val out = File(args[0], "out").empty()
    val debug = File(args[0], "debug").empty()
    debug.runQuartz(tests, src, args[1])
    debug.runTest(src, exe, out, expected)
}

fun File.runQuartz(input: File, output: File, qc: String) {
    runCommand(
            "java -jar $qc ${input.absolutePath} ${output.absolutePath}",
            File(this, "_debug.txt").outputStream()
    )
}

fun File.runTest(src: File, exe: File, out: File, expected: File) {
    if (src.isDirectory) {
        src.listFiles().forEach { runTest(File(src, it.name), File(exe, it.name), File(out, it.name), File(expected, it.name)) }
    } else {
        Thread { runGCC(src, File("$exe.exe"), File("$out.txt"), File("$expected.txt")) }.start()
    }
}

fun File.runGCC(src: File, exe: File, out: File, expected: File) {
    runCommand(
            "gcc ${src.absolutePath} -o ${exe.absolutePath} -Wall -Wextra -Wpedantic",
            File(this, "${exe.nameWithoutExtension}.txt").outputStream()
    )
    runOutput(exe, out)
    verifyOutput(out, expected)
}

// TODO
fun File.runNVCC(src: File, exe: File, out: File, expected: File) {
    runCommand(
            "nvcc ${src.absolutePath} -o ${exe.absolutePath} --machine 32 -x cu -Wno-deprecated-gpu-targets --cudart shared",
            File(this, "${exe.nameWithoutExtension}.txt").outputStream()
    )
    runOutput(exe, out)
    verifyOutput(out, expected)
}

fun runOutput(exe: File, out: File) {
    runCommand(
            exe.absolutePath,
            out.outputStream()
    )
}

fun verifyOutput(out: File, expected: File) {
    if (!expected.exists())
        System.err.println("Unable to verify output for $out")
    else if (out.readText().trim() != expected.readText().trim())
        System.err.println("Incorrect output for $out")
}

fun runCommand(command: String, out: OutputStream, err: OutputStream = out) {
    println("Running command $command")
    Runtime.getRuntime().exec(command).also {
        Thread { while (it.isAlive || it.inputStream.available() > 0) {
            it.inputStream.read().takeIf { it > 0 }?.also { out.write(it) }
        } }.start()
        Thread { while (it.isAlive || it.errorStream.available() > 0) {
            it.errorStream.read().takeIf { it > 0 }?.also {
                err.write(it)
                System.err.write(it)
            }
        } }.start()
    }.waitFor()
}

fun File.empty(): File {
    also { print("Deleting ${it.absolutePath}") }.deleteRecursively().also {
        println(" ... ${if (it) "succeeded" else "failed"}")
    }
    also { print("Creating ${it.absolutePath}") }.mkdir().let {
        println(" ... ${if (it) "succeeded" else "failed"}")
    }
    return this
}
