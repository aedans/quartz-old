package quartz.compiler.parser.parsers.statements.expressions

import quartz.compiler.parser.ParseNode
import quartz.compiler.parser.Parser
import quartz.compiler.parser.parse
import quartz.compiler.parser.parsers.parsenodes.InlineCNode
import quartz.compiler.tokenizer.TokenIterator
import quartz.compiler.tokenizer.TokenType

/**
 * Created by Aedan Smith.
 */

val inlineCParser: Parser<ParseNode> = {
    tokens: TokenIterator, superNode: ParseNode -> tokens.parse {
        if (!peek().equals(TokenType.INLINE_C)){
            false
        } else {
            val cnode = InlineCNode(next().value)
            println("Found $cnode")
            superNode.add(cnode)
            true
        }
    }
}
