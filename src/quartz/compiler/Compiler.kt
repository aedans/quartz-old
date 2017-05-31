@file:Suppress("DEPRECATION") // TODO Fix

package quartz.compiler

import org.antlr.v4.runtime.ANTLRInputStream
import org.antlr.v4.runtime.CommonTokenStream
import quartz.compiler.builder.toNode
import quartz.compiler.errors.ErrorListener
import quartz.compiler.errors.errorScope
import quartz.compiler.generator.CGenerator
import quartz.compiler.generator.Generator
import quartz.compiler.parser.QuartzLexer
import quartz.compiler.parser.QuartzParser
import quartz.compiler.semantics.analyze
import quartz.compiler.tree.Program
import quartz.compiler.tree.library.Library
import java.io.InputStream
import java.io.OutputStream

/**
 * Created by Aedan Smith.
 */

object Compiler {
    fun compile(input: InputStream,
                output: OutputStream,
                library: Library.LibraryPackage,
                parser: InputStream.() -> QuartzParser.ProgramContext = {
                    errorScope({ "parser" }) {
                        val errorListener = ErrorListener()
                        val qlexer = QuartzLexer(ANTLRInputStream(this)).apply { addErrorListener(errorListener) }
                        val qparser = QuartzParser(CommonTokenStream(qlexer)).apply { addErrorListener(errorListener) }
                        qparser.program()
                    }
                },
                builder: QuartzParser.ProgramContext.() -> Program = {
                    errorScope({ "ast builder" }) { toNode(library, parser) }
                },
                analyzer: Program.(Generator) -> Unit = {
                    errorScope({ "semantic analyzer" }) { analyze(it) }
                },
                generator: OutputStream.() -> Generator = {
                    CGenerator(this)
                }
    ) {
        input.parser().builder().analyzer(output.generator())
    }
}
