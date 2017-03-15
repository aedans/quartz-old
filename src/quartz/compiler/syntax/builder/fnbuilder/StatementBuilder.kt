package quartz.compiler.syntax.builder.fnbuilder

import quartz.compiler.parser.ParseNode
import quartz.compiler.parser.parsers.parsenodes.*
import quartz.compiler.syntax.builder.fnbuilder.expression.toExpression
import quartz.compiler.syntax.builder.fnbuilder.statement.toStatement
import quartz.compiler.syntax.nodes.StatementNode
import quartz.compiler.syntax.symboltable.SymbolTable

/**
 * Created by Aedan Smith.
 */

fun ParseNode.statement(symbolTable: SymbolTable, function: FnDeclaration): StatementNode {
    return when (this) {
        is Declaration -> this.toStatement(symbolTable)
        is FnCall -> this.toExpression(symbolTable)
        is Return -> this.toStatement(symbolTable, function)
        is InlineC -> this.toExpression()
        else -> throw RuntimeException("Unrecognized node $this")
    }
}
