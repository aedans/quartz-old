package quartz.compiler

import org.antlr.v4.runtime.CharStreams
import org.antlr.v4.runtime.CommonTokenStream
import quartz.compiler.builder.toExpr
import quartz.compiler.errors.ErrorListener
import quartz.compiler.errors.errorScope
import quartz.compiler.generator.Generator
import quartz.compiler.parser.QuartzLexer
import quartz.compiler.parser.QuartzParser
import quartz.compiler.semantics.SemanticAnalyzer
import quartz.compiler.tree.Program
import quartz.compiler.tree.util.Library
import java.io.InputStream
import java.io.OutputStream

/**
 * Created by Aedan Smith.
 */

typealias CompilerParser = InputStream.() -> QuartzParser.ProgramContext
typealias CompilerBuilder = QuartzParser.ProgramContext.(Library.LibraryPackage, CompilerParser) -> Program
typealias CompilerAnalyzer = Program.() -> Program
typealias CompilerGenerator = Program.(OutputStream) -> Unit

object Compiler {
    val defaultParser: CompilerParser = {
        errorScope({ "parser" }) {
            val errorListener = ErrorListener()
            val qlexer = QuartzLexer(CharStreams.fromReader(reader())).apply { addErrorListener(errorListener) }
            val qparser = QuartzParser(CommonTokenStream(qlexer)).apply { addErrorListener(errorListener) }
            qparser.program()
        }
    }

    val defaultBuilder: CompilerBuilder = { library, parser ->
        errorScope({ "ast builder" }) { toExpr(library, parser) }
    }

    val defaultAnalyzer: CompilerAnalyzer = {
        errorScope({ "semantic analyzer" }) { SemanticAnalyzer.analyzeProgram(this) }
    }

    val defaultGenerator: CompilerGenerator = {
        Generator.generate(it, this)
    }

    fun compile(
            input: InputStream,
            output: OutputStream,
            library: Library.LibraryPackage,
            parser: CompilerParser,
            builder: CompilerBuilder,
            analyzer: CompilerAnalyzer,
            generator: CompilerGenerator
    ) {
        input.parser().builder(library, parser).analyzer().generator(output)
    }
}
