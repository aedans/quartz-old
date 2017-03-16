package quartz.compiler.parser.parsers.expressions

import quartz.compiler.parser.ParseNode
import quartz.compiler.parser.parse
import quartz.compiler.parser.parsers.parsenodes.NumberLiteralNode
import quartz.compiler.syntax.type.types.Primitives
import quartz.compiler.tokenizer.TokenIterator
import quartz.compiler.tokenizer.TokenType
import quartz.compiler.util.ProtoType

/**
 * Created by Aedan Smith.
 */

// TODO Add doubles
val numberParser = {
    tokens: TokenIterator, superNode: ParseNode -> tokens.parse {
        if (!peek().equals(TokenType.NUMBER_LITERAL)) {
            false
        } else {
            val number = next().value
            val numberNode = NumberLiteralNode(number, ProtoType(number) { Primitives.int })
            println("Found $numberNode")

            superNode.add(numberNode)
            true
        }
    }
}
