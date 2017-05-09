package quartz.compiler.semantics.analyzer.function

import quartz.compiler.errors.QuartzException
import quartz.compiler.semantics.analyzer.function.statement.analyze
import quartz.compiler.semantics.analyzer.type.analyze
import quartz.compiler.semantics.symboltable.localSymbolTable
import quartz.compiler.semantics.symboltable.symbolTable
import quartz.compiler.semantics.util.ProgramBuilder
import quartz.compiler.tree.Program
import quartz.compiler.tree.function.FunctionDeclaration

/**
 * Created by Aedan Smith.
 */

fun FunctionDeclaration.analyze(program: Program, programBuilder: ProgramBuilder): FunctionDeclaration {
    return analyzeTypes(program, programBuilder).analyzeBlock(program, programBuilder)
}

fun FunctionDeclaration.analyzeTypes(program: Program, programBuilder: ProgramBuilder): FunctionDeclaration {
    val localSymbolTable = localSymbolTable(program.symbolTable())
    return copy(function = function.run { copy(
            args = args?.map { it?.analyze(localSymbolTable, program, programBuilder)
                    ?: throw QuartzException("Unable to infer types for ${this@analyzeTypes.argsWithNames} in ${this@analyzeTypes.name}")},
            returnType = returnType?.analyze(localSymbolTable, program, programBuilder)
                    ?: throw QuartzException("Unable to infer return type for ${this@analyzeTypes.name}")
    ) })
}

fun FunctionDeclaration.analyzeBlock(program: Program, programBuilder: ProgramBuilder): FunctionDeclaration {
    return copy(block = block.analyze(localSymbolTable(program.symbolTable()), program, programBuilder))
}

