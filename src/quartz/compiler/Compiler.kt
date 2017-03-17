package quartz.compiler

import quartz.compiler.generator.Generator
import quartz.compiler.parser.parsers.ProgramParser
import quartz.compiler.semantics.SemanticAnalyzer
import quartz.compiler.tokenizer.tokenize
import quartz.compiler.tokenizer.tokenizers.*
import quartz.compiler.util.misc.CharStream

/**
 * Created by Aedan Smith.
 */

class Compiler(
        val src: String,
        val programParser: ProgramParser = ProgramParser(),
        val semanticAnalyzer: SemanticAnalyzer = SemanticAnalyzer(),
        val generator: Generator = Generator()
) {
    fun compile(): String {
        val tokens = tokenizers.tokenize(CharStream(src))
        val program = programParser(tokens)
        println('\n' + program.toString())
        semanticAnalyzer.analyze(program)
        println('\n' + program.toString())
        return generator.generate(program)
    }

    val tokenizers = listOf(
            stringLiteralTokenizer,
            numberLiteralTokenizer,
            inlineCTokenizer,
            symbolTokenizer('(', ')', '{', '}', '[', ']', ':', ',', '='),
            wordTokenizer("fn", "val", "var", "return")
    )
}
