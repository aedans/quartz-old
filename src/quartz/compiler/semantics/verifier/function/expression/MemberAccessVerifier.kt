package quartz.compiler.semantics.verifier.function.expression

import quartz.compiler.semantics.verifier.function.verify
import quartz.compiler.semantics.verifier.symboltable.SymbolTable
import quartz.compiler.syntax.tree.program.function.expression.MemberAccessNode
import quartz.compiler.util.types.StructType

/**
 * Created by Aedan Smith.
 */

fun MemberAccessNode.verify(symbolTable: SymbolTable) {
    expression.verify(symbolTable)

    val sType = expression.type as StructType
    val struct = symbolTable.getGlobalSymbolTable().getStruct(sType.name)
    type = struct.members.firstOrNull { it.name == name }?.type
            ?: throw Exception("No member found in ${struct.name} named $name")
}
