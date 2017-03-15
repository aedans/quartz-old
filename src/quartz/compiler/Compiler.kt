package quartz.compiler

import quartz.compiler.generator.Generator
import quartz.compiler.parser.parse
import quartz.compiler.parser.parsers.expressions.inlineCParser
import quartz.compiler.parser.parsers.fnDeclarationParser
import quartz.compiler.parser.parsers.parsenodes.Program
import quartz.compiler.syntax.builder.toSyntaxTree
import quartz.compiler.tokenizer.tokenize
import quartz.compiler.tokenizer.tokenizers.*
import quartz.compiler.util.misc.StringIterator

/**
 * Created by Aedan Smith.
 */

class Compiler(val src: String) {
    fun compile(): String {
        val tokens = tokenizers.tokenize(StringIterator(src))
        val program = parsers.parse(tokens, Program()) { it.hasNext() }
        println('\n' + program.toString(0))
        val syntaxTree = program.toSyntaxTree()
        println(syntaxTree.toString())
        return Generator.generate(syntaxTree)
    }

    val tokenizers = listOf(
            stringLiteralTokenizer,
            numberLiteralTokenizer,
            inlineCTokenizer,
            symbolTokenizer('(', ')', '{', '}', '[', ']', ':', ',', '='),
            wordTokenizer("fn", "val", "var", "return")
    )

    val parsers = listOf(
            fnDeclarationParser,
            inlineCParser
    )
}
