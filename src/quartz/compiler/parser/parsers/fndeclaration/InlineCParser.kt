package quartz.compiler.parser.parsers.fndeclaration

import quartz.compiler.parser.Parser
import quartz.compiler.tree.InlineCNode
import quartz.compiler.parser.verify
import quartz.compiler.tokenizer.TokenType

/**
 * Created by Aedan Smith.
 */

val inlineCParser: Parser<InlineCNode> = { tokens ->
    InlineCNode(tokens.next().verify { it.equals(TokenType.INLINE_C) }.value)
}
