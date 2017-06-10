package quartz.compiler.semantics

import quartz.compiler.semantics.tables.SymbolTable
import quartz.compiler.tree.declarations.ExternFunctionDeclaration
import quartz.compiler.tree.declarations.FunctionDeclaration
import quartz.compiler.tree.expression.Expression
import quartz.compiler.tree.util.Type

/**
 * Created by Aedan Smith.
 */

data class Analyzer(
        val analyzeFunctionDeclaration: Analyzer.(SymbolTable, FunctionDeclaration) -> FunctionDeclaration,
        val analyzeExternFunctionDeclaration: Analyzer.(SymbolTable, ExternFunctionDeclaration) -> ExternFunctionDeclaration,
        val analyzeExpression: Analyzer.(SymbolTable, Type, Expression) -> Expression,
        val analyzeType: Analyzer.(SymbolTable, Type) -> Type
) {
    operator fun plus(analyzer: Analyzer.(SymbolTable, Type, Expression) -> Expression): Analyzer {
        return copy(analyzeExpression = { table, expected, expr ->
            this@Analyzer.analyzeExpression(this, table, expected, expr)
                    .let { analyzer(table, expected, it) }
        })
    }
}
