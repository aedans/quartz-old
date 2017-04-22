package quartz.compiler.semantics

import quartz.compiler.errors.QuartzException
import quartz.compiler.errors.errorScope
import quartz.compiler.semantics.symboltable.SymbolTable
import quartz.compiler.semantics.types.FunctionType
import quartz.compiler.tree.function.expression.Identifier
import quartz.compiler.tree.function.expression.MemberAccess
import quartz.compiler.tree.function.statement.FunctionCall

/**
 * Created by Aedan Smith.
 */

fun FunctionCall.resolveDotNotation(symbolTable: SymbolTable): FunctionCall {
    return errorScope({ "dot notation resolver" }) {
        errorScope({ "$this" }) {
            if (expression !is MemberAccess)
                throw QuartzException("Dot notation ambiguity in $this")

            val expressionType = symbolTable.getVar(expression.name) as? FunctionType
                    ?: throw QuartzException("Could not find function ${expression.name}")
            FunctionCall(
                    Identifier(expression.name, expressionType),
                    listOf(expression.expression) + args,
                    type
            )
        }
    }
}
