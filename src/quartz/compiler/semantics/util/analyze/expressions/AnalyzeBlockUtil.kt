package quartz.compiler.semantics.util.analyze.expressions

import quartz.compiler.semantics.tables.SymbolTable
import quartz.compiler.semantics.types.UnknownType
import quartz.compiler.semantics.util.withVar
import quartz.compiler.tree.expression.Expression
import quartz.compiler.tree.expression.expressions.Block
import quartz.compiler.tree.expression.expressions.VariableDeclaration
import quartz.compiler.tree.util.Type

/**
 * Created by Aedan Smith.
 */

fun Block.analyzeExpressions(
        analyzer: (SymbolTable, Type, Expression) -> Expression,
        table: SymbolTable,
        expectedType: Type
): Block {
    return Block(analyzeExpressionsContextually(analyzer, table, expectedType))
}

fun List<Expression>.analyzeExpressionsContextually(
        analyzer: (SymbolTable, Type, Expression) -> Expression,
        table: SymbolTable,
        expectedType: Type
): List<Expression> {
    return when (size) {
        0 -> emptyList()
        1 -> listOf(analyzer(table, expectedType, first()))
        else -> {
            val analyzed = analyzer(table, UnknownType, first())
            val newTable = if (analyzed is VariableDeclaration) table.withVar(analyzed.name, analyzed.variableType) else table
            listOf(analyzed) + drop(1).analyzeExpressionsContextually(analyzer, newTable, expectedType)
        }
    }
}
