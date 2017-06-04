package quartz.compiler.semantics.util.visitors

import quartz.compiler.semantics.contexts.SymbolContext
import quartz.compiler.semantics.util.withVar
import quartz.compiler.tree.function.Block
import quartz.compiler.tree.function.Expression
import quartz.compiler.tree.function.expression.VariableDeclaration
import quartz.compiler.tree.util.Type
import quartz.compiler.util.Visitor

/**
 * Created by Aedan Smith.
 */

// TODO
fun ((SymbolContext, Type?, Expression) -> Expression).blockVisitor(symbolContext: SymbolContext): Visitor<Block> {
    return {
        val mutableExpressionList = mutableListOf<Expression>()
        var mutableSymbolContext = symbolContext
        it.expressionList.forEach {
            val expression = this(mutableSymbolContext, null, it)
            mutableExpressionList.add(expression)
            if (expression is VariableDeclaration)
                mutableSymbolContext = mutableSymbolContext.withVar(expression.name, expression.variableType!!)
        }
        Block(mutableExpressionList)
    }
}
