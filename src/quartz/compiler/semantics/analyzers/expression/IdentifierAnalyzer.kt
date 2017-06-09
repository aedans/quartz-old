package quartz.compiler.semantics.analyzers.expression

import quartz.compiler.errors.QuartzException
import quartz.compiler.semantics.tables.SymbolTable
import quartz.compiler.tree.expression.expressions.Identifier
import quartz.compiler.tree.util.Type

/**
 * Created by Aedan Smith.
 */

object IdentifierAnalyzer {
    inline fun analyzeType(
            typeAnalyzer: (SymbolTable, Type) -> Type,
            variableTable: SymbolTable,
            identifier: Identifier
    ): Identifier {
        return identifier.run {
            val expectedType = variableTable.getVar(name)
                    ?: throw QuartzException("Could not find variable $name")

            Identifier(name, typeAnalyzer(variableTable, expectedType))
        }
    }
}
