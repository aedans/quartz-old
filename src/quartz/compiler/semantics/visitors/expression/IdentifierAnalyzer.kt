package quartz.compiler.semantics.visitors.expression

import quartz.compiler.errors.QuartzException
import quartz.compiler.semantics.consumers.GlobalDeclarationConsumer
import quartz.compiler.semantics.symbols.VariableTable
import quartz.compiler.tree.GlobalDeclaration
import quartz.compiler.tree.function.expression.Identifier

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

    inline fun visitGlobalDeclaration(
            consumer: GlobalDeclarationConsumer,
            supplier: (String) -> GlobalDeclaration?,
            identifier: Identifier
    ) {
        supplier(identifier.name)?.also { consumer.eat(it) }
    }
}
