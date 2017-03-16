package quartz.compiler.syntax.builder.fnbuilder.expression

import quartz.compiler.parser.parsers.parsenodes.CastNode
import quartz.compiler.syntax.builder.fnbuilder.expression
import quartz.compiler.syntax.nodes.enodes.Cast
import quartz.compiler.syntax.symboltable.SymbolTable

/**
 * Created by Aedan Smith.
 */

fun CastNode.toExpression(symbolTable: SymbolTable): Cast {
    val type = this.type.toType()
    val expression = this.getNodes()!![0].expression(symbolTable)
    if (!expression.evalType.canCastTo(type)) {
        throw RuntimeException("Could not cast ${expression.evalType} to $type")
    }
    return Cast(expression, type)
}
