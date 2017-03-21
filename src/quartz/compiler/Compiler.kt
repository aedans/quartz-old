package quartz.compiler

import org.antlr.v4.runtime.ANTLRInputStream
import org.antlr.v4.runtime.CommonTokenStream
import quartz.compiler.generator.Generator
import quartz.compiler.parser.QuartzLexer
import quartz.compiler.parser.QuartzParser
import quartz.compiler.semantics.SemanticAnalyzer
import quartz.compiler.semantics.analyze
import quartz.compiler.semantics.translator.translate
import quartz.compiler.semantics.verifier.verify
import quartz.compiler.syntax.builder.toNode
import quartz.compiler.syntax.tree.ProgramNode
import java.io.InputStream

/**
 * Created by Aedan Smith.
 */

object Compiler {
    fun compile(input: InputStream,
                parser: (InputStream) -> ProgramNode = {
                    QuartzParser(CommonTokenStream(QuartzLexer(ANTLRInputStream(it)))).program().toNode()
                },
                semanticAnalyzers: List<SemanticAnalyzer> = listOf(
                        ProgramNode::verify,
                        ProgramNode::translate
                ),
                generator: (ProgramNode) -> String = Generator::generate
    ): String {
        val program = parser(input)
        println('\n' + program.toString())
        semanticAnalyzers.analyze(program)
        println(program.toString())
        return generator(program)
    }
}
