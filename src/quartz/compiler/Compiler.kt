package quartz.compiler

import org.antlr.v4.runtime.ANTLRInputStream
import org.antlr.v4.runtime.CommonTokenStream
import quartz.compiler.generator.Generator
import quartz.compiler.parser.QuartzLexer
import quartz.compiler.parser.QuartzParser
import quartz.compiler.semantics.SemanticAnalyzer
import quartz.compiler.semantics.analyze
import quartz.compiler.semantics.function.FnDeclarationAnalyzer
import quartz.compiler.semantics.misc.externFnAnalyzer
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
                semanticAnalyzers: List<SemanticAnalyzer<ProgramNode>> = listOf(
                        externFnAnalyzer,
                        FnDeclarationAnalyzer()
                ),
                generator: Generator = Generator()
    ): String {
        val program = parser(input)
        println('\n' + program.toString())
        semanticAnalyzers.analyze(program)
        println(program.toString())
        return generator.generate(program)
    }
}
