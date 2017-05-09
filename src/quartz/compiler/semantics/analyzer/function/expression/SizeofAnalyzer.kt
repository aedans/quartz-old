package quartz.compiler.semantics.analyzer.function.expression

import quartz.compiler.semantics.analyzer.type.analyze
import quartz.compiler.semantics.symboltable.SymbolTable
import quartz.compiler.semantics.util.ProgramBuilder
import quartz.compiler.tree.Program
import quartz.compiler.tree.function.expression.Sizeof

/**
 * Created by Aedan Smith.
 */

fun Sizeof.analyze(symbolTable: SymbolTable, program: Program, programBuilder: ProgramBuilder): Sizeof {
    return Sizeof(sizeType.analyze(symbolTable, program, programBuilder))
}
