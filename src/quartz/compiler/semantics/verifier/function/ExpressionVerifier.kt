package quartz.compiler.semantics.verifier.function

import quartz.compiler.semantics.verifier.function.expression.verify
import quartz.compiler.semantics.verifier.function.statement.verify
import quartz.compiler.semantics.verifier.symboltable.SymbolTable
import quartz.compiler.syntax.tree.program.InlineCNode
import quartz.compiler.syntax.tree.program.function.ExpressionNode
import quartz.compiler.syntax.tree.program.function.expression.*
import quartz.compiler.syntax.tree.program.function.statement.FnCallNode

/**
 * Created by Aedan Smith.
 */

fun ExpressionNode.verify(symbolTable: SymbolTable) {
    when (this) {
        is NumberLiteralNode -> { }
        is StringLiteralNode -> { }
        is InlineCNode -> { }
        is IdentifierNode -> verify(symbolTable)
        is IfExpressionNode -> verify(symbolTable)
        is OneArgOperatorNode -> verify(symbolTable)
        is TwoArgOperatorNode -> verify(symbolTable)
        is FnCallNode -> verify(symbolTable)
        else -> throw Exception("Unrecognized node $this")
    }
}
