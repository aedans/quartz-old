package quartz.compiler.syntax.builder.fnbuilder

import quartz.compiler.parser.ParseNode
import quartz.compiler.parser.parsers.parsenodes.*
import quartz.compiler.syntax.builder.fnbuilder.expression.toExpression
import quartz.compiler.syntax.builder.fnbuilder.statement.toStatement
import quartz.compiler.syntax.nodes.Statement
import quartz.compiler.syntax.symboltable.SymbolTable

/**
 * Created by Aedan Smith.
 */

fun ParseNode.statement(symbolTable: SymbolTable, function: FnDeclarationNode): Statement {
    return when (this) {
        is VarDeclarationNode -> this.toStatement(symbolTable)
        is FnCallNode -> this.toExpression(symbolTable)
        is ReturnNode -> this.toStatement(symbolTable, function)
        is InlineCNode -> this.toExpression()
        else -> throw RuntimeException("Unrecognized node $this")
    }
}
