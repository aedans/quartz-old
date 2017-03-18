package quartz.compiler

import quartz.compiler.generator.Generator
import quartz.compiler.parser.parsers.ProgramParser
import quartz.compiler.semantics.SemanticAnalyzer
import quartz.compiler.semantics.analyze
import quartz.compiler.semantics.function.FnDeclarationAnalyzer
import quartz.compiler.semantics.misc.externFnAnalyzer
import quartz.compiler.tokenizer.Tokenizer
import quartz.compiler.tokenizer.tokenize
import quartz.compiler.tokenizer.tokenizers.*
import quartz.compiler.tree.ProgramNode
import quartz.compiler.util.misc.CharStream

/**
 * Created by Aedan Smith.
 */

class Compiler(
        val src: String,
        val tokenizers: List<Tokenizer> = listOf(
                stringLiteralTokenizer,
                numberLiteralTokenizer,
                inlineCTokenizer,
                symbolTokenizer('(', ')', '{', '}', '[', ']', ':', ',', '='),
                wordTokenizer("val", "var", "fn", "extern_fn", "return", "if", "else", "while")
        ),
        val programParser: ProgramParser = ProgramParser(),
        val semanticAnalyzers: List<SemanticAnalyzer<ProgramNode>> = listOf(
                externFnAnalyzer,
                FnDeclarationAnalyzer()
        ),
        val generator: Generator = Generator()
) {
    fun compile(): String {
        val tokens = tokenizers.tokenize(CharStream(src))
        val program = programParser(tokens)
        println('\n' + program.toString())
        semanticAnalyzers.analyze(program)
        println(program.toString())
        return generator.generate(program)
    }
}
