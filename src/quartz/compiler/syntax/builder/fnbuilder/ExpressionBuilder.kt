package quartz.compiler.syntax.builder.fnbuilder

import quartz.compiler.parser.ParseNode
import quartz.compiler.parser.parsers.parsenodes.*
import quartz.compiler.syntax.builder.fnbuilder.expression.toExpression
import quartz.compiler.syntax.nodes.Expression
import quartz.compiler.syntax.symboltable.SymbolTable

/**
 * Created by Aedan Smith.
 */

fun ParseNode.expression(symbolTable: SymbolTable): Expression {
    return when (this) {
        is NumberLiteralNode -> this.toExpression()
        is StringLiteralNode -> this.toExpression()
        is IdentifierNode -> this.toExpression(symbolTable)
        is FnCallNode -> this.toExpression(symbolTable)
        is CastNode -> this.toExpression(symbolTable)
        is InlineCNode -> this.toExpression()
        else -> throw RuntimeException("Unrecognized node $this")
    }
}
