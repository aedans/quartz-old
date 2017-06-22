package quartz.compiler.semantics.util.analyze.expressions

import quartz.compiler.semantics.tables.FunctionDeclarationSymbolTable
import quartz.compiler.semantics.tables.SymbolTable
import quartz.compiler.semantics.types.UnknownType
import quartz.compiler.semantics.types.VoidType
import quartz.compiler.tree.declarations.FunctionDeclaration
import quartz.compiler.tree.expression.Expression
import quartz.compiler.tree.expression.expressions.Block
import quartz.compiler.tree.util.Type

/**
 * Created by Aedan Smith.
 */

inline fun FunctionDeclaration.analyzeBlock(
        table: SymbolTable,
        expressionAnalyzer: (SymbolTable, Type, Expression) -> Expression
): FunctionDeclaration {
    val symbolTable = FunctionDeclarationSymbolTable(table, this)
    val expected = if (function.returnType == VoidType) UnknownType else function.returnType
    return copy(block = expressionAnalyzer(symbolTable, expected, block) as Block)
}
