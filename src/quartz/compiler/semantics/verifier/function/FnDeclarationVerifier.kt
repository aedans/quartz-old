package quartz.compiler.semantics.verifier.function

import quartz.compiler.semantics.verifier.symboltable.SymbolTable
import quartz.compiler.syntax.tree.program.FnDeclarationNode
import quartz.compiler.util.Variable

/**
 * Created by Aedan Smith.
 */

fun FnDeclarationNode.verify(symbolTable: SymbolTable) {
    args.forEach { (name, type) -> symbolTable.add(name, Variable(name, type)) }
    statements.forEach { it.verify(symbolTable) }
}
