package quartz.compiler.syntax.builder.fnbuilder.expression

import quartz.compiler.parser.parsers.parsenodes.FnCall
import quartz.compiler.syntax.builder.fnbuilder.expression
import quartz.compiler.syntax.nodes.enodes.CastNode
import quartz.compiler.syntax.nodes.enodes.FnCallNode
import quartz.compiler.util.symboltable.SymbolTable

/**
 * Created by Aedan Smith.
 */

fun FnCall.toExpression(symbolTable: SymbolTable): FnCallNode {
    val function = symbolTable.getGlobalSymbolTable().getFunction(this.name)
    return FnCallNode(
            function.name,
            this.getNodes().mapIndexed { i, it ->
                val expression = it.expression(symbolTable)
                if (expression.evalType != function.args[i]) {
                    CastNode(it.expression(symbolTable), function.args[i])
                } else {
                    it.expression(symbolTable)
                }
            },
            function.returnType
    )
}
