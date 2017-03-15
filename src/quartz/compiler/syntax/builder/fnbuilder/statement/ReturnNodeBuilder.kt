package quartz.compiler.syntax.builder.fnbuilder.statement

import quartz.compiler.parser.parsers.parsenodes.FnDeclaration
import quartz.compiler.parser.parsers.parsenodes.Return
import quartz.compiler.syntax.builder.fnbuilder.expression
import quartz.compiler.syntax.nodes.enodes.CastNode
import quartz.compiler.syntax.nodes.snodes.ReturnNode
import quartz.compiler.syntax.symboltable.SymbolTable

/**
 * Created by Aedan Smith.
 */

fun Return.toStatement(symbolTable: SymbolTable, function: FnDeclaration): ReturnNode {
    val expression = this.getNodes()!![0].expression(symbolTable)
    val rType = function.rType.toType()

    if (!expression.evalType.canCastTo(rType))
        throw RuntimeException("Could not cast ${expression.evalType} to $rType")

    return if (expression.evalType != rType) {
        ReturnNode(CastNode(expression, rType))
    } else {
        ReturnNode(expression)
    }
}
