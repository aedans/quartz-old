package quartz.compiler.semantics.util.visitors

import quartz.compiler.semantics.symbols.SymbolTable
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
fun ((SymbolTable, Type?, Expression) -> Expression).blockVisitor(symbolTable: SymbolTable): Visitor<Block> {
    return {
        val mutableExpressionList = mutableListOf<Expression>()
        var mutableSymbolTable = symbolTable
        it.expressionList.forEach {
            val expression = this(mutableSymbolTable, null, it)
            mutableExpressionList.add(expression)
            if (expression is VariableDeclaration)
                mutableSymbolTable = mutableSymbolTable.withVar(expression.name, expression.variableType!!)
        }
        Block(mutableExpressionList)
    }
}

