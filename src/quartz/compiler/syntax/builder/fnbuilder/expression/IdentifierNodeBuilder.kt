package quartz.compiler.syntax.builder.fnbuilder.expression

import quartz.compiler.parser.parsers.parsenodes.Identifier
import quartz.compiler.syntax.nodes.enodes.IdentifierNode
import quartz.compiler.syntax.symboltable.SymbolTable

/**
 * Created by Aedan Smith.
 */

fun Identifier.toExpression(symbolTable: SymbolTable): IdentifierNode {
    return IdentifierNode(this.name, symbolTable[this.name].type)
}
