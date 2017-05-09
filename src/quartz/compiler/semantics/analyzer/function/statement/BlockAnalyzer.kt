package quartz.compiler.semantics.analyzer.function.statement

import quartz.compiler.semantics.analyzer.function.analyze
import quartz.compiler.semantics.symboltable.SymbolTable
import quartz.compiler.semantics.util.BlockBuilder
import quartz.compiler.semantics.util.ProgramBuilder
import quartz.compiler.tree.Program
import quartz.compiler.tree.function.statement.Block

/**
 * Created by Aedan Smith.
 */

fun Block.analyze(symbolTable: SymbolTable, program: Program, programBuilder: ProgramBuilder): Block {
    return analyzeStatements(symbolTable, program, programBuilder)
}

fun Block.analyzeStatements(symbolTable: SymbolTable, program: Program, programBuilder: ProgramBuilder): Block {
    return Block(statementList.analyze(BlockBuilder(symbolTable), program, programBuilder))
}
