package quartz.compiler.syntax.builder.fnbuilder.statement

import quartz.compiler.parser.parsers.parsenodes.FnDeclarationNode
import quartz.compiler.parser.parsers.parsenodes.ReturnNode
import quartz.compiler.syntax.builder.fnbuilder.expression
import quartz.compiler.syntax.nodes.enodes.Cast
import quartz.compiler.syntax.nodes.snodes.Return
import quartz.compiler.syntax.symboltable.SymbolTable

/**
 * Created by Aedan Smith.
 */

fun ReturnNode.toStatement(symbolTable: SymbolTable, function: FnDeclarationNode): Return {
    val expression = this.getNodes()!![0].expression(symbolTable)
    val rType = function.rType.toType()

    if (!expression.evalType.canCastTo(rType))
        throw RuntimeException("Could not cast ${expression.evalType} to $rType")

    return if (expression.evalType != rType) {
        Return(Cast(expression, rType))
    } else {
        Return(expression)
    }
}
