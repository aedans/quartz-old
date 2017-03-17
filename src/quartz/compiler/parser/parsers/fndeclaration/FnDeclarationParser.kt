package quartz.compiler.parser.parsers.fndeclaration

import quartz.compiler.parser.*
import quartz.compiler.parser.nodes.FnDeclarationNode
import quartz.compiler.parser.nodes.statement.ReturnNode
import quartz.compiler.parser.parsers.fndeclaration.expression.identifierParser
import quartz.compiler.parser.parsers.fndeclaration.expression.numberLiteralParser
import quartz.compiler.parser.parsers.fndeclaration.expression.stringLiteralParser
import quartz.compiler.parser.parsers.fndeclaration.statement.FnCallParser
import quartz.compiler.parser.parsers.fndeclaration.statement.ReturnParser
import quartz.compiler.parser.parsers.fndeclaration.statement.VarDeclarationParser
import quartz.compiler.tokenizer.TokenStream
import quartz.compiler.tokenizer.TokenType
import quartz.compiler.util.Type
import types.Primitives

/**
 * Created by Aedan Smith.
 */

class FnDeclarationParser(
        val expressionParser: ExpressionParser = ExpressionParser().apply expressionParser@ { this.subParsers.apply {
            add(numberLiteralParser)
            add(stringLiteralParser)
            add(inlineCParser)
            add(FnCallParser(this@expressionParser))
            add(identifierParser)
        } },
        val statementParser: StatementParser = StatementParser().apply { this.subParsers.apply {
            add(inlineCParser)
            add(FnCallParser(expressionParser))
            add(VarDeclarationParser(expressionParser))
            add(ReturnParser(expressionParser))
        } }
): Parser<FnDeclarationNode> {
    override fun invoke(tokens: TokenStream): FnDeclarationNode = tokens.parse {
        next().verify { it.equals(TokenType.KEYWORD, "fn") }
        val name = next().verify { it.equals(TokenType.IDENTIFIER) }.value
        next().verify { it.equals(TokenType.SYMBOL, "(") }

        val args = ArrayList<Pair<String, Type>>()

        loop@ while (true) {
            when {
                peek().equals(TokenType.SYMBOL, ")") -> break@loop
                peek().equals(TokenType.SYMBOL, ",") -> next()
                peek().equals(TokenType.IDENTIFIER) -> {
                    @Suppress("NAME_SHADOWING")
                    val name = tokens.next().verify { it.equals(TokenType.IDENTIFIER) }.value
                    next().verify { it.equals(TokenType.SYMBOL, ":") }
                    args.add(name to parseType())
                }
                else -> invalidToken(peek())
            }
        }

        next()

        val returnType = when {
            peek().equals(TokenType.SYMBOL, ":") -> {
                next()
                parseType()
            }
            // TODO
            else -> Primitives.void
        }

        val fnDeclarationNode = FnDeclarationNode(name, args, returnType)
        println("Found $fnDeclarationNode")

        if (peek().equals(TokenType.SYMBOL, "{")) {
            next()

            loop@ while (!peek().equals(TokenType.SYMBOL, "}")) {
                fnDeclarationNode.statements.add(statementParser(tokens))
            }

            next()
        } else if (peek().equals(TokenType.SYMBOL, "=")) {
            next()

            if (returnType == Primitives.void) {
                fnDeclarationNode.statements.add(expressionParser(tokens))
            } else {
                fnDeclarationNode.statements.add(ReturnNode(expressionParser(tokens)))
            }
        }

        fnDeclarationNode
    }
}