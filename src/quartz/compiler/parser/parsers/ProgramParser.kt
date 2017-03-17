package quartz.compiler.parser.parsers

import quartz.compiler.parser.Parser
import quartz.compiler.parser.invalidToken
import quartz.compiler.parser.nodes.ExpressionNode
import quartz.compiler.parser.nodes.ProgramNode
import quartz.compiler.parser.nodes.StatementNode
import quartz.compiler.parser.parse
import quartz.compiler.parser.parsers.fndeclaration.ExpressionParser
import quartz.compiler.parser.parsers.fndeclaration.FnDeclarationParser
import quartz.compiler.parser.parsers.fndeclaration.expression.identifierParser
import quartz.compiler.parser.parsers.fndeclaration.expression.numberLiteralParser
import quartz.compiler.parser.parsers.fndeclaration.expression.stringLiteralParser
import quartz.compiler.parser.parsers.fndeclaration.inlineCParser
import quartz.compiler.parser.parsers.fndeclaration.statement.FnCallParser
import quartz.compiler.parser.parsers.fndeclaration.statement.ReturnParser
import quartz.compiler.parser.parsers.fndeclaration.statement.VarDeclarationParser
import quartz.compiler.tokenizer.Token
import quartz.compiler.tokenizer.TokenStream
import quartz.compiler.tokenizer.TokenType

/**
 * Created by Aedan Smith.
 */

class ProgramParser(val fnDeclarationParser: FnDeclarationParser = FnDeclarationParser()) : Parser<ProgramNode> {
    override fun invoke(tokens: TokenStream): ProgramNode {
        return tokens.parse {
            tokens.parse {
                val program = ProgramNode()
                while (hasNext()) when {
                    peek().equals(TokenType.KEYWORD, "fn") -> {
                        program.fnDeclarations.add(fnDeclarationParser(tokens))
                    }
                    peek().equals(TokenType.INLINE_C) -> {
                        program.inlineCNodes.add(inlineCParser(tokens))
                    }
                    else -> invalidToken(peek(), Token(TokenType.KEYWORD, "fn"))
                }
                program
            }
        }
    }
}

private fun getDefaultStatementParsers(expressionParser: ExpressionParser): MutableList<(TokenStream) -> StatementNode> {
    return mutableListOf(
            inlineCParser,
            FnCallParser(expressionParser),
            VarDeclarationParser(expressionParser),
            ReturnParser(expressionParser)
    )
}

private fun getDefaultExpressionParsers(expressionParser: ExpressionParser): MutableList<(TokenStream) -> ExpressionNode> {
    return mutableListOf(
            numberLiteralParser,
            stringLiteralParser,
            inlineCParser,
            FnCallParser(expressionParser),
            identifierParser
    )
}
