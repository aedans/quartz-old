package quartz.compiler.cli

import com.xenomachina.argparser.SystemExitException
import quartz.compiler.Compiler
import quartz.compiler.Compiler.defaultAnalyzer
import quartz.compiler.Compiler.defaultBuilder
import quartz.compiler.Compiler.defaultGenerator
import quartz.compiler.Compiler.defaultParser
import quartz.compiler.CompilerAnalyzer
import quartz.compiler.CompilerBuilder
import quartz.compiler.tree.pretty.printPretty
import kotlin.system.measureTimeMillis

/**
 * Created by Aedan Smith.
 */

val debugBuilder: CompilerBuilder = { library, parser ->
    Compiler.defaultBuilder(this, library, parser).also {
        println("Builder:\n")
        it.printPretty(System.out)
    }
}

val debugAnalyzer: CompilerAnalyzer = {
    Compiler.defaultAnalyzer(this).also {
        println("Analyzer:\n")
        it.printPretty(System.out)
    }
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
