package quartz.compiler

import org.antlr.v4.runtime.ANTLRInputStream
import org.antlr.v4.runtime.CommonTokenStream
import quartz.compiler.builder.toNode
import quartz.compiler.generator.Generator
import quartz.compiler.parser.QuartzLexer
import quartz.compiler.parser.QuartzParser
import quartz.compiler.semantics.*
import quartz.compiler.tree.Program
import quartz.compiler.tree.import.Library
import java.io.InputStream
import java.io.OutputStream

/**
 * Created by Aedan Smith.
 */

object Compiler {
    fun compile(input: InputStream,
                output: OutputStream,
                library: Library.LibraryPackage,
                parser: (InputStream) -> QuartzParser.ProgramContext = {
                    QuartzParser(CommonTokenStream(QuartzLexer(ANTLRInputStream(it)))).program()
                },
                builder: (QuartzParser.ProgramContext) -> Program = {
                    it.toNode(library, parser)
                },
                analyzer: Program.() -> Program = {
                    this
                            .generateConstructors()
                            .resolveTypes()
                            .verifyTypes()
                            .simplify()
                            .resolveFunctionTemplates()
                            .resolveTypeTemplates()
                },
                generator: (Program, OutputStream) -> Unit = Generator::write
    ) {
        var program = builder(parser(input))
        println('\n' + program.toString())
        program = analyzer(program)
        println(program.toString())
        generator(program, output)
    }
}
