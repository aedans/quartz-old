package quartz.compiler.semantics.visitors.expression

import quartz.compiler.errors.QuartzException
import quartz.compiler.semantics.symbols.VariableTable
import quartz.compiler.tree.function.FunctionDeclaration
import quartz.compiler.tree.function.expression.Identifier
import quartz.compiler.tree.misc.ExternFunctionDeclaration

/**
 * Created by Aedan Smith.
 */

object IdentifierAnalyzer {
    fun analyzeType(variableTable: VariableTable, identifier: Identifier): Identifier {
        return identifier.run {
            val expectedType = variableTable.getVar(name)
                    ?: throw QuartzException("Could not find variable $name")

            Identifier(name, emptyList(), expectedType)
        }
    }

    inline fun consumeFunctionDeclaration(
            consumer: (FunctionDeclaration) -> Unit,
            supplier: (String) -> FunctionDeclaration?,
            identifier: Identifier
    ) {
        supplier(identifier.name)?.also { consumer(it) }
    }

    inline fun consumeExternFunctionDeclaration(
            consumer: (ExternFunctionDeclaration) -> Unit,
            supplier: (String) -> ExternFunctionDeclaration?,
            identifier: Identifier
    ) {
        supplier(identifier.name)?.also { consumer(it) }
    }
}
