package quartz.compiler.parser.parsers

import quartz.compiler.parser.ParseException
import quartz.compiler.parser.Parser
import quartz.compiler.parser.invalidToken
import quartz.compiler.parser.parse
import quartz.compiler.parser.parsers.fndeclaration.FnDeclarationParser
import quartz.compiler.parser.parsers.fndeclaration.inlineCParser
import quartz.compiler.tokenizer.TokenStream
import quartz.compiler.tree.FnDeclarationNode
import quartz.compiler.tree.InlineCNode
import quartz.compiler.tree.ProgramNode

/**
 * Created by Aedan Smith.
 */

class ProgramParser(
        val subParsers: MutableList<Pair<Parser<Any>, (Any, ProgramNode) -> Unit>> = mutableListOf(
                FnDeclarationParser() to { node, program -> program.fnDeclarations.add(node as FnDeclarationNode) },
                inlineCParser to { node, program -> program.inlineCNodes.add(node as InlineCNode) }
        )
) : Parser<ProgramNode> {
    override fun invoke(tokens: TokenStream): ProgramNode {
        return tokens.parse {
            val program = ProgramNode()
            loop@ while (hasNext()) {
                val fallback = index
                for ((parser, consumer) in subParsers) {
                    try {
                        consumer(parser(this), program)
                        continue@loop
                    } catch (e: ParseException) {
                        index = fallback
                    }
                }
                invalidToken(peek())
            }
            program
        }
    }
}
