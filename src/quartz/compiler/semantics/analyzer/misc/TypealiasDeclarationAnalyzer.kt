package quartz.compiler.semantics.analyzer.misc

import quartz.compiler.semantics.analyzer.type.analyze
import quartz.compiler.semantics.symboltable.SymbolTable
import quartz.compiler.semantics.util.ProgramBuilder
import quartz.compiler.tree.Program
import quartz.compiler.tree.misc.TypealiasDeclaration

/**
 * Created by Aedan Smith.
 */

fun TypealiasDeclaration.analyze(symbolTable: SymbolTable, program: Program, programBuilder: ProgramBuilder): TypealiasDeclaration {
    return copy(aliasedType = aliasedType.analyze(symbolTable, program, programBuilder))
}
