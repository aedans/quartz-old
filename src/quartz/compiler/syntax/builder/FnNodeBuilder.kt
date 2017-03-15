package quartz.compiler.syntax.builder

import quartz.compiler.parser.parsers.parsenodes.FnDeclaration
import quartz.compiler.syntax.builder.fnbuilder.statement
import quartz.compiler.syntax.nodes.FnNode
import quartz.compiler.syntax.type.toType
import quartz.compiler.util.Variable
import quartz.compiler.syntax.symboltable.LocalSymbolTable
import quartz.compiler.syntax.symboltable.SymbolTable

/**
 * Created by Aedan Smith.
 */

fun FnDeclaration.toFunctionNode(symbolTable: SymbolTable): FnNode {
    val localSymbolTable = LocalSymbolTable(symbolTable)

    val fnNode = FnNode(this.name, this.args.map { it.first to it.second.toType() }, this.rType.toType())
    fnNode.args.forEach { localSymbolTable.add(it.first, Variable(it.first, it.second)) }
    for (node in this.getNodes()) {
        fnNode.statements.add(node.statement(localSymbolTable, this))
    }
    return fnNode
}
