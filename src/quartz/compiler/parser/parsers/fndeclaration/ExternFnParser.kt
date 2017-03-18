package quartz.compiler.parser.parsers.fndeclaration

import quartz.compiler.parser.*
import quartz.compiler.tokenizer.TokenType
import quartz.compiler.util.Function
import quartz.compiler.util.Type
import types.Primitives

/**
 * Created by Aedan Smith.
 */

val externFnParser: Parser<Function> = { tokens ->
    tokens.parse {
        next().verify { it.equals(TokenType.KEYWORD, "extern_fn") }
        val name = next().verify { it.equals(TokenType.IDENTIFIER) }.value
        next().verify { it.equals(TokenType.SYMBOL, "(") }

        val args = ArrayList<Type>()

        loop@ while (true) {
            when {
                peek().equals(TokenType.SYMBOL, ")") -> break@loop
                peek().equals(TokenType.SYMBOL, ",") -> next()
                peek().equals(TokenType.IDENTIFIER) -> {
                    args.add(parseType())
                }
                else -> invalidToken(peek())
            }
        }

        next()

        val returnType = when {
            hasNext(2) && peek().equals(TokenType.SYMBOL, ":") -> {
                next()
                parseType()
            }
        // TODO
            else -> Primitives.void
        }

        Function(name, args, returnType)
    }
}