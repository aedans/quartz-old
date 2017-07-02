package quartz.compiler.semantics.util.analyze.expressions

import quartz.compiler.semantics.tables.FunctionDeclarationSymbolTable
import quartz.compiler.semantics.tables.SymbolTable
import quartz.compiler.semantics.types.VoidType
import quartz.compiler.tree.declarations.FunctionDeclaration
import quartz.compiler.tree.expression.Expression
import quartz.compiler.tree.util.Type

/**
 * Created by Aedan Smith.
 */

inline fun FunctionDeclaration.analyzeExpression(
        table: SymbolTable,
        expressionAnalyzer: (SymbolTable, Type?, Expression) -> Expression
): FunctionDeclaration {
    val symbolTable = FunctionDeclarationSymbolTable(table, this)
    val expected = if (function.returnType == VoidType) null else function.returnType
    return copy(expression = expressionAnalyzer(symbolTable, expected, expression))
}
