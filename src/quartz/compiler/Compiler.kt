package quartz.compiler

import org.antlr.v4.runtime.ANTLRInputStream
import org.antlr.v4.runtime.CommonTokenStream
import quartz.compiler.generator.Generator
import quartz.compiler.parser.QuartzLexer
import quartz.compiler.parser.QuartzParser
import quartz.compiler.semantics.generateConstructors
import quartz.compiler.semantics.generateSymbolTable
import quartz.compiler.semantics.verifyTypes
import quartz.compiler.syntax.builder.toNode
import quartz.compiler.syntax.tree.ProgramNode
import quartz.compiler.syntax.tree.import.Library
import quartz.compiler.visitor.plus
import java.io.InputStream

/**
 * Created by Aedan Smith.
 */

object Compiler {
    fun compile(input: InputStream,
                library: Library.LibraryPackage,
                parser: (InputStream) -> QuartzParser.ProgramContext = {
                    QuartzParser(CommonTokenStream(QuartzLexer(ANTLRInputStream(it)))).program()
                },
                builder: (QuartzParser.ProgramContext) -> ProgramNode = {
                    it.toNode(library, parser)
                },
                analyzer: ProgramNode.() -> ProgramNode = {
                    val symbolTable = this.generateSymbolTable()
                    (
                            { it: ProgramNode -> it.generateConstructors(symbolTable) } +
                            { it.verifyTypes(symbolTable) }
                    )(this)
                },
                generator: (ProgramNode) -> String = Generator::generate
    ): String {
        var program = builder(parser(input))
        println('\n' + program.toString())
        program = program.analyzer()
        println(program.toString())
        return generator(program)
    }
}
