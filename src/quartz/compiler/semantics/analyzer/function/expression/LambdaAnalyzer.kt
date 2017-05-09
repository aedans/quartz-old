package quartz.compiler.semantics.analyzer.function.expression

import quartz.compiler.semantics.analyzer.function.analyze
import quartz.compiler.semantics.analyzer.function.statement.analyze
import quartz.compiler.semantics.symboltable.SymbolTable
import quartz.compiler.semantics.symboltable.localSymbolTable
import quartz.compiler.semantics.types.FunctionType
import quartz.compiler.semantics.util.ProgramBuilder
import quartz.compiler.tree.Program
import quartz.compiler.tree.function.FunctionDeclaration
import quartz.compiler.tree.function.expression.Identifier
import quartz.compiler.tree.function.expression.Lambda
import quartz.compiler.util.Type

/**
 * Created by Aedan Smith.
 */

fun Lambda.analyze(
        symbolTable: SymbolTable,
        program: Program,
        programBuilder: ProgramBuilder,
        expected: Type?
): Identifier {
    return analyzeTypes(symbolTable, program, programBuilder, expected).generate(program, programBuilder)
}

fun Lambda.analyzeTypes(
        symbolTable: SymbolTable,
        program: Program,
        programBuilder: ProgramBuilder,
        expected: Type?
): Lambda {
    return when {
        expected is FunctionType && function != expected.function -> copy(function = expected.function)
                .analyzeTypes(symbolTable, program, programBuilder, expected)
        function.args == null -> copy(function = function.copy(args = emptyList()))
                .analyzeTypes(symbolTable, program, programBuilder, expected)
//        function.returnType == null -> copy(function = function.copy(returnType = block.verifyReturnType(null)))
//                .analyzeTypes(symbolTable, program, programBuilder, expected)
        argNames == null -> copy(argNames = function.args.mapIndexed { i, _ -> "p$i" })
                .analyzeTypes(symbolTable, program, programBuilder, expected)
        else -> {
            val localSymbolTable = localSymbolTable(symbolTable)
            val newBlock = block.analyze(localSymbolTable, program, programBuilder)
            return Lambda(argNames, function, newBlock)
        }
    }
}

fun Lambda.generate(program: Program, programBuilder: ProgramBuilder): Identifier {
    val name = "__lambda_${programBuilder.nameSupplier.next()}"
    val functionDeclaration = FunctionDeclaration(
            name,
            argNames!!,
            type.function,
            block
    )
    programBuilder.program += functionDeclaration
    val analyzedFunction = functionDeclaration.analyze(program, programBuilder)
    programBuilder.program += analyzedFunction
    return Identifier(name, type)
}
