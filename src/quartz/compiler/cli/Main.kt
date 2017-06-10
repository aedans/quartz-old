package quartz.compiler.cli

import com.xenomachina.argparser.SystemExitException
import quartz.compiler.Compiler
import kotlin.system.measureTimeMillis

/**
 * Created by Aedan Smith.
 */

fun main(args: Array<String>) {
    try {
        val quartzArgs = QuartzArgs(args)
        time(quartzArgs.time) {
            Compiler.compile(
                    quartzArgs.inputFile.inputStream(),
                    quartzArgs.outputFile.outputStream(),
                    quartzArgs.library + quartzArgs.includes,
                    Compiler.defaultParser,
                    if (quartzArgs.debugBuilder) Compiler.debugBuilder else Compiler.defaultBuilder,
                    if (quartzArgs.debugAnalyzer) Compiler.debugAnalyzer else Compiler.defaultAnalyzer,
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
