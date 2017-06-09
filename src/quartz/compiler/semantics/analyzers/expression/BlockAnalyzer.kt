package quartz.compiler.semantics.analyzers.expression

import quartz.compiler.semantics.tables.SymbolTable
import quartz.compiler.semantics.util.withVar
import quartz.compiler.tree.expression.Expression
import quartz.compiler.tree.expression.expressions.Block
import quartz.compiler.tree.expression.expressions.VariableDeclaration
import quartz.compiler.tree.util.Type
import quartz.compiler.util.Visitor

/**
 * Created by Aedan Smith.
 */

object BlockAnalyzer {
    inline fun visitExpressions(expressionVisitor: Visitor<Expression>, block: Block): Block {
        return Block(block.expressionList.map(expressionVisitor))
    }

    inline fun analyzeBlock(
            analyzer: ((SymbolTable, Type?, Expression) -> Expression),
            symbolTable: SymbolTable,
            block: Block
    ): Block {
        val mutableExpressionList = mutableListOf<Expression>()
        var mutableSymbolContext = symbolTable
        block.expressionList.forEach {
            val expression = analyzer(mutableSymbolContext, null, it)
            mutableExpressionList.add(expression)
            if (expression is VariableDeclaration)
                mutableSymbolContext = mutableSymbolContext.withVar(expression.name, expression.variableType!!)
        }
        return Block(mutableExpressionList)
    }
}
