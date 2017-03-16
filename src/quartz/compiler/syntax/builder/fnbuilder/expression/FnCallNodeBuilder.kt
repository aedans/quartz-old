package quartz.compiler.syntax.builder.fnbuilder.expression

import quartz.compiler.parser.parsers.parsenodes.FnCallNode
import quartz.compiler.syntax.builder.fnbuilder.expression
import quartz.compiler.syntax.nodes.enodes.Cast
import quartz.compiler.syntax.nodes.enodes.FnCall
import quartz.compiler.syntax.symboltable.SymbolTable

/**
 * Created by Aedan Smith.
 */

fun FnCallNode.toExpression(symbolTable: SymbolTable): FnCall {
    val function = symbolTable.getGlobalSymbolTable().getFunction(this.name)
    return FnCall(
            function.name,
            getNodes().mapIndexed { i, it ->
                val expression = it.expression(symbolTable)
                if (expression.evalType != function.args[i]) {
                    Cast(it.expression(symbolTable), function.args[i])
                } else {
                    it.expression(symbolTable)
                }
            },
            function.returnType
    )
}
