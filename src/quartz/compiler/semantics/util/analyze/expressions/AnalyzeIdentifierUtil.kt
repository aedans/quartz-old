package quartz.compiler.semantics.util.analyze.expressions

import quartz.compiler.errors.QuartzException
import quartz.compiler.semantics.tables.SymbolTable
import quartz.compiler.tree.expression.expressions.Identifier
import quartz.compiler.tree.util.Type

/**
 * Created by Aedan Smith.
 */

inline fun Identifier.analyzeType(
        typeAnalyzer: (SymbolTable, Type) -> Type,
        variableTable: SymbolTable
): Identifier {
    val expectedType = variableTable.getVar(name)
            ?: throw QuartzException("Could not find variable $name")

    return Identifier(name, typeAnalyzer(variableTable, expectedType))
}
