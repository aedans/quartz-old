package quartz.compiler.semantics.analyzer.misc

import quartz.compiler.semantics.analyzer.type.analyze
import quartz.compiler.semantics.symboltable.symbolTable
import quartz.compiler.semantics.util.ProgramBuilder
import quartz.compiler.tree.Program
import quartz.compiler.tree.misc.ExternFunctionDeclaration

/**
 * Created by Aedan Smith.
 */

fun ExternFunctionDeclaration.analyze(program: Program, programBuilder: ProgramBuilder): ExternFunctionDeclaration {
    return copy(function = function.run { copy(
            args = args?.map { it?.analyze(program.symbolTable(), program, programBuilder) },
            returnType = returnType?.analyze(program.symbolTable(), program, programBuilder)
    ) })
}
