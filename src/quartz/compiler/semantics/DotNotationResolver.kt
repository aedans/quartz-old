package quartz.compiler.semantics

import quartz.compiler.exceptions.QuartzException
import quartz.compiler.semantics.symboltable.SymbolTable
import quartz.compiler.semantics.types.FunctionType
import quartz.compiler.tree.function.expression.IdentifierNode
import quartz.compiler.tree.function.expression.MemberAccessNode
import quartz.compiler.tree.function.statement.FnCallNode
import quartz.compiler.util.plus

/**
 * Created by Aedan Smith.
 */

fun FnCallNode.resolveDotNotation(symbolTable: SymbolTable): FnCallNode {
    if (expression !is MemberAccessNode)
        throw QuartzException("Dot notation ambiguity in $this")

    val expressionType = symbolTable.getVar(expression.name) as? FunctionType
            ?: throw QuartzException("Could not find function ${expression.name}")
    return FnCallNode(
            IdentifierNode(expression.name, expressionType),
            templates,
            expression.expression + expressions,
            type
    )
}
