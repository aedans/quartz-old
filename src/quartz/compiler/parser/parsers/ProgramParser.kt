package quartz.compiler.parser.parsers

import quartz.compiler.parser.Parser
import quartz.compiler.parser.invalidToken
import quartz.compiler.parser.parse
import quartz.compiler.parser.parsers.fndeclaration.FnDeclarationParser
import quartz.compiler.parser.parsers.fndeclaration.inlineCParser
import quartz.compiler.tokenizer.TokenStream
import quartz.compiler.tokenizer.TokenType
import quartz.compiler.tree.ProgramNode

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
                    else -> invalidToken(peek())
                }
                program
            }
        }
    }
}
