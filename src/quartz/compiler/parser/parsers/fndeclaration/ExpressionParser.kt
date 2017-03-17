package quartz.compiler.parser.parsers.fndeclaration

import quartz.compiler.parser.ParseException
import quartz.compiler.parser.Parser
import quartz.compiler.tree.ExpressionNode
import quartz.compiler.parser.parse
import quartz.compiler.parser.parsers.fndeclaration.expression.identifierParser
import quartz.compiler.parser.parsers.fndeclaration.expression.numberLiteralParser
import quartz.compiler.parser.parsers.fndeclaration.expression.stringLiteralParser
import quartz.compiler.parser.parsers.fndeclaration.statement.FnCallParser
import quartz.compiler.parser.parsers.fndeclaration.inlineCParser
import quartz.compiler.tokenizer.TokenStream

/**
 * Created by Aedan Smith.
 */

class ExpressionParser : Parser<ExpressionNode> {
    val subParsers: MutableList<Parser<ExpressionNode>> = mutableListOf(
            numberLiteralParser,
            stringLiteralParser,
            inlineCParser,
            FnCallParser(this),
            identifierParser
    )

    override fun invoke(tokens: TokenStream): ExpressionNode {
        return tokens.parse {
            val fallback = tokens.index
            for (parser in subParsers) {
                try {
                    return@parse parser(this)
                } catch (e: ParseException) {
                    tokens.index = fallback
                }
            }
            throw Exception("Unexpected token ${tokens.peek()}")
        }
    }
}
