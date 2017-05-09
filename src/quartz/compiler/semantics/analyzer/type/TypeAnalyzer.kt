package quartz.compiler.semantics.analyzer.type

import quartz.compiler.errors.QuartzException
import quartz.compiler.semantics.analyzer.misc.analyze
import quartz.compiler.semantics.symboltable.SymbolTable
import quartz.compiler.semantics.types.*
import quartz.compiler.semantics.util.ProgramBuilder
import quartz.compiler.tree.Program
import quartz.compiler.util.Type

/**
 * Created by Aedan Smith.
 */

fun Type.analyze(symbolTable: SymbolTable, program: Program, programBuilder: ProgramBuilder): Type {
    return when (this) {
        is VoidType -> this
        is NumberType -> this
        is ConstType -> copy(type = type.analyze(symbolTable, program, programBuilder))
        is PointerType -> copy(type = type.analyze(symbolTable, program, programBuilder))
        is FunctionType -> copy(function = function.run { copy(
                args = args?.map { it?.analyze(symbolTable, program, programBuilder) },
                returnType = returnType?.analyze(symbolTable, program, programBuilder)
        ) })
        is AliasedType -> analyze(symbolTable, program, programBuilder)
        is StructType -> analyze(symbolTable, program, programBuilder)
        is UnresolvedType -> {
            symbolTable.getType(string)?.analyze(symbolTable, program, programBuilder)
                    ?: throw QuartzException("Unable to resolve type $this")
        }
        else -> throw QuartzException("Expected type, found $this")
    }
}

fun StructType.analyze(symbolTable: SymbolTable, program: Program, programBuilder: ProgramBuilder): StructType {
    val structDeclaration = program.structDeclarations[string]
            ?: throw QuartzException("Unknown struct $this")

    if (!programBuilder.program.structDeclarations.contains(string)) {
        programBuilder.program += structDeclaration
        programBuilder.program += structDeclaration.analyze(symbolTable, program, programBuilder)
    }

    val newStructDeclaration = programBuilder.program.structDeclarations[string]
            ?: throw QuartzException("Unknown struct $this")

    return StructType(newStructDeclaration)
}

fun AliasedType.analyze(symbolTable: SymbolTable, program: Program, programBuilder: ProgramBuilder): AliasedType {
    val typealiasDeclaration = program.typealiasDeclarations[string]
            ?: throw QuartzException("Unknown typealias $this")

    if (!programBuilder.program.typealiasDeclarations.contains(string)) {
        programBuilder.program += typealiasDeclaration
        programBuilder.program += typealiasDeclaration.analyze(symbolTable, program, programBuilder)
    }

    val newTypealiasDeclaration = programBuilder.program.typealiasDeclarations[string]
            ?: throw QuartzException("Unknown typealias $this")

    return AliasedType(newTypealiasDeclaration)
}
