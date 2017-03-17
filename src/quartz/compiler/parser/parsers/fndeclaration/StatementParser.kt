package quartz.compiler.parser.parsers.fndeclaration

import quartz.compiler.parser.ParseException
import quartz.compiler.parser.Parser
import quartz.compiler.tree.StatementNode
import quartz.compiler.parser.parse
import quartz.compiler.tokenizer.TokenStream

/**
 * Created by Aedan Smith.
 */

class StatementParser : Parser<StatementNode> {
    val subParsers: MutableList<Parser<StatementNode>> = mutableListOf()

    override fun invoke(tokens: TokenStream): StatementNode {
        return tokens.parse {
            val fallback = tokens.index
            for (parser in subParsers) {
                try {
                    val node = parser(this)
                    // TODO flush tokens
                    return@parse node
                } catch (e: ParseException) {
                    tokens.index = fallback
                }
            }
            throw Exception("Unexpected token ${tokens.peek()}")
        }
    }
}
