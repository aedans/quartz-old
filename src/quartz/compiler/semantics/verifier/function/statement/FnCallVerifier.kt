package quartz.compiler.semantics.verifier.function.statement

import quartz.compiler.semantics.verifier.function.verify
import quartz.compiler.semantics.verifier.symboltable.SymbolTable
import quartz.compiler.semantics.verifier.verifyType
import quartz.compiler.syntax.tree.program.function.statement.FnCallNode
import quartz.compiler.util.Function

/**
 * Created by Aedan Smith.
 */

fun FnCallNode.verify(symbolTable: SymbolTable) {
    val function = symbolTable.getGlobalSymbolTable().getFunction(name)
            ?: throw Exception("Could not find function $name")

    type = function.returnType

    if (function.args.size != expressions.size)
        throw Exception("Incorrect number of arguments for $this")

    for (i in 0 until expressions.size) {
        expressions[i].verify(symbolTable)
        verifyType(
                function.args[i],
                { invalidArguments(this, function) },
                expressions[i],
                { expressions[i] = it },
                { invalidArguments(this, function) }
        )
    }
}

private fun invalidArguments(node: FnCallNode, function: Function): Nothing {
    var s = "Invalid arguments for $node: expected ["
    function.args.forEach { s += it.toString() + " " }
    s = s.substring(0, s.length - 1) + "], found ["
    node.expressions.forEach { s += it.type.toString() + " " }
    s = s.substring(0, s.length - 1) + "]"
    throw Exception(s)
}
