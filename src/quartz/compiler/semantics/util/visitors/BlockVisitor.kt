package quartz.compiler.semantics.util.visitors

import quartz.compiler.semantics.tables.SymbolTable
import quartz.compiler.semantics.util.withVar
import quartz.compiler.tree.expression.Block
import quartz.compiler.tree.expression.Expression
import quartz.compiler.tree.expression.expressions.VariableDeclaration
import quartz.compiler.tree.util.Type
import quartz.compiler.util.Visitor

/**
 * Created by Aedan Smith.
 */

// TODO
fun ((SymbolTable, Type?, Expression) -> Expression).blockVisitor(symbolTable: SymbolTable): Visitor<Block> {
    return {
        val mutableExpressionList = mutableListOf<Expression>()
        var mutableSymbolContext = symbolTable
        it.expressionList.forEach {
            val expression = this(mutableSymbolContext, null, it)
            mutableExpressionList.add(expression)
            if (expression is VariableDeclaration)
                mutableSymbolContext = mutableSymbolContext.withVar(expression.name, expression.variableType!!)
        }
        Block(mutableExpressionList)
    }
}
