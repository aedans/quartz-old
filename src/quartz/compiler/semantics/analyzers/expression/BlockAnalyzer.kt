package quartz.compiler.semantics.analyzers.expression

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

object BlockAnalyzer {
    fun analyzeExpressions(
            analyzer: ((SymbolTable, Type, Expression) -> Expression),
            table: SymbolTable,
            expectedType: Type,
            block: List<Expression>
    ): Block {
        return when (block.size) {
            0 -> Block(emptyList())
            1 -> Block(listOf(analyzer(table, expectedType, block.first())))
            else -> {
                val analyzed = analyzer(table, UnknownType, block.first())
                val newTable = if (analyzed is VariableDeclaration) table.withVar(analyzed.name, analyzed.variableType) else table
                Block(listOf(analyzed) + analyzeExpressions(analyzer, newTable, expectedType, block.drop(1)))
            }
        }
    }
}
