package quartz.compiler.semantics.analyzer.function.expression

import quartz.compiler.errors.QuartzException
import quartz.compiler.semantics.analyzer.function.analyze
import quartz.compiler.semantics.analyzer.misc.analyze
import quartz.compiler.semantics.symboltable.SymbolTable
import quartz.compiler.semantics.types.FunctionType
import quartz.compiler.semantics.util.BlockBuilder
import quartz.compiler.semantics.util.ProgramBuilder
import quartz.compiler.tree.Program
import quartz.compiler.tree.function.expression.Identifier

/**
 * Created by Aedan Smith.
 */

fun Identifier.analyze(blockBuilder: BlockBuilder, program: Program, programBuilder: ProgramBuilder): Identifier {
    return this
            .resolveFunction(blockBuilder, program, programBuilder)
            .resolveExternalFunction(blockBuilder, program, programBuilder)
            .verify(blockBuilder.symbolTable)
}

fun Identifier.verify(symbolTable: SymbolTable): Identifier {
    val expectedType = symbolTable.getVar(name) ?: throw QuartzException("Could not find variable $name ${symbolTable}")
    val newType = when {
        type == null -> expectedType
        type.isInstance(expectedType) -> type
        expectedType.isInstance(type) -> expectedType
        else ->  throw QuartzException("Expected $expectedType, found $type ($this)")
    }
    return Identifier(name, newType)
}

fun Identifier.resolveFunction(blockBuilder: BlockBuilder, program: Program, programBuilder: ProgramBuilder): Identifier {
    var newFunction = program.functionDeclarations[name] ?: return this

    if (!programBuilder.program.functionDeclarations.contains(newFunction.name)) {
        programBuilder.program += newFunction
        newFunction = newFunction.analyze(program, programBuilder)
        programBuilder.program += newFunction
    }

    blockBuilder.symbolTable += newFunction.name to FunctionType(newFunction.function)

    return copy(name = newFunction.name, type = FunctionType(newFunction.function))
}

// TODO Unify
fun Identifier.resolveExternalFunction(blockBuilder: BlockBuilder, program: Program, programBuilder: ProgramBuilder): Identifier {
    var newFunction = program.externFunctionDeclarations[name] ?: return this

    if (!programBuilder.program.externFunctionDeclarations.contains(newFunction.name)) {
        programBuilder.program += newFunction
        newFunction = newFunction.analyze(program, programBuilder)
        programBuilder.program += newFunction
    }

    blockBuilder.symbolTable += newFunction.name to FunctionType(newFunction.function)

    return copy(name = newFunction.name, type = FunctionType(newFunction.function))
}
