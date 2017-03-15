package quartz.compiler.syntax.builder.fnbuilder.expression

import quartz.compiler.parser.parsers.parsenodes.Cast
import quartz.compiler.syntax.builder.fnbuilder.expression
import quartz.compiler.syntax.nodes.enodes.CastNode
import quartz.compiler.util.symboltable.SymbolTable

/**
 * Created by Aedan Smith.
 */

fun Cast.toExpression(symbolTable: SymbolTable): CastNode {
    val type = this.type.toType()
    val expression = this.getNodes()!![0].expression(symbolTable)
    if (!expression.evalType.canCastTo(type)) {
        throw RuntimeException("Could not cast ${expression.evalType} to $type")
    }
    return CastNode(expression, type)
}
