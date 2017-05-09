package quartz.compiler.semantics.analyzer.misc

import quartz.compiler.semantics.analyzer.type.analyze
import quartz.compiler.semantics.symboltable.SymbolTable
import quartz.compiler.semantics.util.ProgramBuilder
import quartz.compiler.tree.Program
import quartz.compiler.tree.struct.StructDeclaration

/**
 * Created by Aedan Smith.
 */

fun StructDeclaration.analyze(symbolTable: SymbolTable, program: Program, programBuilder: ProgramBuilder): StructDeclaration {
    return copy(members = members.mapValues { it.value.copy(type = it.value.type.analyze(symbolTable, program, programBuilder)) })
}
