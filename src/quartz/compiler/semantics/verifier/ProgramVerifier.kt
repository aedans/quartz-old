package quartz.compiler.semantics.verifier

import quartz.compiler.semantics.verifier.function.verify
import quartz.compiler.semantics.verifier.symboltable.GlobalSymbolTable
import quartz.compiler.semantics.verifier.symboltable.LocalSymbolTable
import quartz.compiler.syntax.tree.ProgramNode
import quartz.compiler.syntax.tree.program.function.FnDeclarationNode
import quartz.compiler.syntax.tree.program.function.expression.CastNode
import quartz.compiler.syntax.tree.program.function.statement.ReturnNode
import quartz.compiler.syntax.tree.program.misc.InlineCNode
import quartz.compiler.util.Function

/**
 * Created by Aedan Smith.
 */

fun ProgramNode.verify() {
    val globalSymbolTable = GlobalSymbolTable()

    structDeclarations.forEach {
        val structConstructor = FnDeclarationNode(it.name, it.members.map { it.name to it.type }, it.type)
        var s = "(struct ${it.type}) {"
        structConstructor.args.dropLast(1).forEach { s += it.first + "," }
        s += structConstructor.args.last().first + "}"
        structConstructor.statements.add(ReturnNode(CastNode(it.type, InlineCNode(s))))
        fnDeclarations.add(structConstructor)
        globalSymbolTable.addStruct(it)
    }

    fnDeclarations.forEach { globalSymbolTable.addFunction(Function(it.name, it.args.map { it.second }, it.returnType)) }

    externFnDeclarations.forEach { globalSymbolTable.addFunction(it) }

    for (fnDeclarationNode in fnDeclarations) {
        val localSymbolTable = LocalSymbolTable(globalSymbolTable)
        fnDeclarationNode.verify(localSymbolTable)
    }
}
