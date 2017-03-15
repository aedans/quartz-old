package quartz.compiler.syntax.builder.fnbuilder

import quartz.compiler.parser.ParseNode
import quartz.compiler.parser.parsers.parsenodes.*
import quartz.compiler.syntax.builder.fnbuilder.expression.toExpression
import quartz.compiler.syntax.nodes.ExpressionNode
import quartz.compiler.syntax.symboltable.SymbolTable

/**
 * Created by Aedan Smith.
 */

fun ParseNode.expression(symbolTable: SymbolTable): ExpressionNode {
    return when (this) {
        is NumberLiteral -> this.toExpression()
        is StringLiteral -> this.toExpression()
        is Identifier -> this.toExpression(symbolTable)
        is FnCall -> this.toExpression(symbolTable)
        is Cast -> this.toExpression(symbolTable)
        is InlineC -> this.toExpression()
        else -> throw RuntimeException("Unrecognized node $this")
    }
}
