package quartz.compiler.parser.parsers

import quartz.compiler.parser.*
import quartz.compiler.parser.parsers.parsenodes.FnDeclarationNode
import quartz.compiler.parser.parsers.parsenodes.ProgramNode
import quartz.compiler.parser.parsers.parsenodes.ReturnNode
import quartz.compiler.parser.parsers.statements.statementParsers
import quartz.compiler.syntax.type.types.Primitives
import quartz.compiler.tokenizer.TokenIterator
import quartz.compiler.tokenizer.TokenType
import quartz.compiler.util.ProtoType

/**
 * Created by Aedan Smith.
 */

val fnDeclarationParser: Parser<ProgramNode> = {
    tokens: TokenIterator, superNode: ParseNode -> tokens.parse {
        if (!peek().equals(TokenType.KEYWORD, "fn")){
            false
        } else {
            next()
            val name = next().verify { it.equals(TokenType.IDENTIFIER) }.value
            val args = parseFnArgs(this)
            val rType = parseFnReturn(this)
            val functionNode = FnDeclarationNode(name, args, rType)

            println("Found $functionNode")

            when {
                peek().equals(TokenType.SYMBOL, "{") -> {
                    next() // No need to double check
                    statementParsers.parse(tokens, functionNode, { tokens -> !tokens.peek().equals(TokenType.SYMBOL, "}") })
                    next() // No need to double check
                }
                peek().equals(TokenType.SYMBOL, "=") -> {
                    next() // no need to double check
                    val returnNode = ReturnNode()
                    statementParsers.parse(tokens, returnNode, 1)
                    functionNode.add(returnNode)
                }
                else -> invalidToken(peek())
            }

            superNode.add(functionNode)
            true
        }
    }
}

private fun parseFnArgs(tokens: TokenIterator): ArrayList<Pair<String, ProtoType>> {
    val args = ArrayList<Pair<String, ProtoType>>()
    tokens.parse {
        next().verify { it.equals(TokenType.SYMBOL, "(") }
        loop@
        while (true) {
            when {
                peek().equals(TokenType.SYMBOL, ")") -> break@loop
                peek().equals(TokenType.SYMBOL, ",") -> next() // No need to double check
                peek().equals(TokenType.IDENTIFIER) -> args.add(parseNameType(this))
                else -> invalidToken(peek())
            }
        }
        next() // No need to double check
    }
    return args
}

private fun parseFnReturn(tokens: TokenIterator): ProtoType {
    return tokens.parse {
        when {
            peek().equals(TokenType.SYMBOL, ":") -> {
                next() // No need to double check
                parseType()
            }
            else -> ProtoType("void") { Primitives.void }
        }
    }
}

private fun parseNameType(tokens: TokenIterator): Pair<String, ProtoType> {
    return tokens.parse {
        val name = tokens.next().verify { it.equals(TokenType.IDENTIFIER) }.value
        next().verify { it.equals(TokenType.SYMBOL, ":") }
        val type = parseType()
        name to type
    }
}
