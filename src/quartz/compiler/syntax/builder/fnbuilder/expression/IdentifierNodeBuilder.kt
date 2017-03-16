package quartz.compiler.syntax.builder.fnbuilder.expression

import quartz.compiler.parser.parsers.parsenodes.IdentifierNode
import quartz.compiler.syntax.nodes.enodes.Identifier
import quartz.compiler.syntax.symboltable.SymbolTable

/**
 * Created by Aedan Smith.
 */

fun IdentifierNode.toExpression(symbolTable: SymbolTable): Identifier {
    return Identifier(name, symbolTable[name].type)
}
