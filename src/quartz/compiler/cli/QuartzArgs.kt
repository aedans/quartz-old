package quartz.compiler.cli

import com.xenomachina.argparser.ArgParser
import com.xenomachina.argparser.default
import quartz.compiler.errors.QuartzException
import quartz.compiler.tree.Library
import java.io.File

/**
 * Created by Aedan Smith.
 */

class QuartzArgs(args: Array<String>) {
    val parser = ArgParser(args, helpFormatter = QuartzHelpFormatter())

    val inputFile by parser.positional("SOURCE", help = "the quartz source file") { File(this) }
    val outputFile by parser.storing("-o", "--output", help = "set the output file") { File(this) }
            .default(File("main.c"))
    val library by parser.storing("-l", "--library", help = "set the quartz standard library") { Library.create(File(this)) }
            .default(Library.create(File(System.getenv()["QZ_LIB"] ?: throw QuartzException("Environment variable QZ_LIB is not set"))))
    val includes by parser.adding("-I", "--include", help = "include libraries") { Library.create(File(this)) } // TODO test
    val time by parser.flagging("-t", "--time", help = "time the compiler in milliseconds").default(false)
    val debugBuilder by parser.flagging("--debug-builder", help = "enable debug builder").default(false)
    val debugAnalyzer by parser.flagging("--debug-analyzer", help = "enable debug analyzer").default(false)
}
