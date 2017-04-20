package quartz.compiler.semantics

import quartz.compiler.errors.errorScope
import quartz.compiler.semantics.types.FunctionType
import quartz.compiler.semantics.types.Primitives
import quartz.compiler.tree.Program
import quartz.compiler.tree.function.FunctionDeclaration
import quartz.compiler.tree.function.Statement
import quartz.compiler.tree.function.expression.Identifier
import quartz.compiler.tree.function.statement.Delete
import quartz.compiler.tree.function.statement.FunctionCall
import quartz.compiler.tree.misc.InlineC

/**
 * Created by Aedan Smith.
 */

fun Program.resolveDeletes(): Program {
    return errorScope({ "delete resolver" }) {
        this.mapStatements { (it as? Delete)?.resolve(destructorDeclarations) ?: it }
    }
}

fun Delete.resolve(destructorDeclarations: Map<String, FunctionDeclaration>): Statement {
    errorScope({ "$this" }) {
        val destructor = destructorDeclarations[expression.type?.string]
        return if (destructor == null) InlineC("/* ${expression.type?.descriptiveString} does not have a destructor */") else
            FunctionCall(
                    Identifier(destructor.name, FunctionType(destructor.function)),
                    expression.type.asStruct()!!.templates,
                    listOf(expression),
                    Primitives.void
            )
    }
}
