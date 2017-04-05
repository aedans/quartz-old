package quartz.compiler.semantics

import quartz.compiler.exceptions.QuartzException
import quartz.compiler.semantics.symboltable.SymbolTable
import quartz.compiler.semantics.types.FunctionType
import quartz.compiler.tree.function.expression.Identifier
import quartz.compiler.tree.function.expression.MemberAccess
import quartz.compiler.tree.function.statement.FunctionCall
import quartz.compiler.util.plus

/**
 * Created by Aedan Smith.
 */

fun FunctionCall.resolveDotNotation(symbolTable: SymbolTable): FunctionCall {
    if (expression !is MemberAccess)
        throw QuartzException("Dot notation ambiguity in $this")

    val expressionType = symbolTable.getVar(expression.name) as? FunctionType
            ?: throw QuartzException("Could not find function ${expression.name}")
    return FunctionCall(
            Identifier(expression.name, expressionType),
            templates,
            expression.expression + expressions,
            type
    )
}
