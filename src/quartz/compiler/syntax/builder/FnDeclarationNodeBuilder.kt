package quartz.compiler.syntax.builder

import quartz.compiler.parser.parsers.parsenodes.FnDeclarationNode
import quartz.compiler.syntax.builder.fnbuilder.statement
import quartz.compiler.syntax.nodes.FnDeclaration
import quartz.compiler.syntax.symboltable.LocalSymbolTable
import quartz.compiler.syntax.symboltable.SymbolTable
import quartz.compiler.util.Variable

/**
 * Created by Aedan Smith.
 */

fun FnDeclarationNode.toFunctionNode(symbolTable: SymbolTable): FnDeclaration {
    val localSymbolTable = LocalSymbolTable(symbolTable)

    val fnNode = quartz.compiler.syntax.nodes.FnDeclaration(name, args.map { it.first to it.second.toType() }, rType.toType())
    fnNode.args.forEach { localSymbolTable.add(it.first, Variable(it.first, it.second)) }
    for (node in this.getNodes()) {
        fnNode.statements.add(node.statement(localSymbolTable, this))
    }
    return fnNode
}
