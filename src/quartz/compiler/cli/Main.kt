package quartz.compiler.cli

import com.xenomachina.argparser.SystemExitException
import quartz.compiler.Compiler
import quartz.compiler.CompilerAnalyzer
import quartz.compiler.CompilerBuilder
import quartz.compiler.tree.toFancyString
import kotlin.system.measureTimeMillis

/**
 * Created by Aedan Smith.
 */

val debugBuilder: CompilerBuilder = { library, parser ->
    Compiler.defaultBuilder(this, library, parser).also { println("\nBuilder:\n\n${it.toFancyString()}") }
}

val debugAnalyzer: CompilerAnalyzer = {
    Compiler.defaultAnalyzer(this).also { println("\nAnalyzer:\n\n${it.toFancyString()}") }
}

fun main(args: Array<String>) {
    try {
        val quartzArgs = QuartzArgs(args)
        time(quartzArgs.time) {
            Compiler.compile(
                    quartzArgs.inputFile.inputStream(),
                    quartzArgs.outputFile.outputStream(),
                    quartzArgs.library + quartzArgs.includes,
                    Compiler.defaultParser,
                    if (quartzArgs.debugBuilder) debugBuilder else Compiler.defaultBuilder,
                    if (quartzArgs.debugAnalyzer) debugAnalyzer else Compiler.defaultAnalyzer,
                    Compiler.defaultGenerator
            )
        }
    } catch (e: SystemExitException) {
        e.printAndExit()
    }
}

private inline fun time(boolean: Boolean, func: () -> Unit) {
    if (boolean) {
        println("Compiled in ${measureTimeMillis(func)}ms")
    } else {
        func()
    }
}
