package quartz.compiler.semantics.function.statement

import quartz.compiler.tree.StatementNode
import quartz.compiler.tree.statement.FnCallNode
import quartz.compiler.semantics.SemanticCheck
import quartz.compiler.semantics.checkType
import quartz.compiler.semantics.function.ExpressionCheck
import quartz.compiler.semantics.symboltable.SymbolTable
import quartz.compiler.util.Function

/**
 * Created by Aedan Smith.
 */

class FnCallCheck(val expressionCheck: ExpressionCheck) : SemanticCheck<StatementNode> {
    override fun invoke(node: StatementNode, symbolTable: SymbolTable) {
        if (node !is FnCallNode)
            return

        val function = symbolTable.getGlobalSymbolTable().getFunction(node.name)

        node.type = function.returnType

        if (function.args.size != node.expressions.size)
            throw Exception("Incorrect number of arguments for $node")

        for (i in 0 until node.expressions.size) {
            expressionCheck(node.expressions[i], symbolTable)
            checkType(
                    function.args[i],
                    { invalidArguments(node, function) },
                    node.expressions[i],
                    { node.expressions[i] = it },
                    { invalidArguments(node, function) }
            )
        }
    }

    private fun invalidArguments(node: FnCallNode, function: Function): Nothing {
        var s = "Invalid arguments for $node: expected ["
        function.args.forEach { s += it.toString() + " " }
        s = s.substring(0, s.length-1) + "], found ["
        node.expressions.forEach { s += it.type.toString() + " " }
        s = s.substring(0, s.length-1) + "]"
        throw Exception(s)
    }
}
