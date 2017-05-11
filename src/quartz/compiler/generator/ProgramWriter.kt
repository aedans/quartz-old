package quartz.compiler.generator

import quartz.compiler.errors.QuartzException
import quartz.compiler.generator.program.*
import quartz.compiler.semantics.types.FunctionType
import quartz.compiler.semantics.types.StructType
import quartz.compiler.semantics.types.UnresolvedType
import quartz.compiler.util.Type

/**
 * Created by Aedan Smith.
 */

fun ProgramOutputStream.writeAll() {
    program.inlineCDeclarations.forEach { inlineC(it) }

    program.externFunctionDeclarations.forEach { declare(FunctionType(it.value.function)) }
    program.functionDeclarations.forEach { declare(FunctionType(it.value.function)) }
    program.structDeclarations.forEach { declare(StructType(it.value)) }

    program.structDeclarations.filterValues { !it.external }.forEach { structPrototype(it.value) }
    program.structDeclarations.filterValues { !it.external }.forEach { struct(it.value) }

    program.functionDeclarations.forEach { functionPrototype(it.value) }
    program.functionDeclarations.forEach { function(it.value) }
}

fun ProgramOutputStream.declare(type: Type) {
    when (type) {
        is StructType -> struct(program.structDeclarations[type.string]
                    ?: throw QuartzException("Unknown struct ${type.string}"))
        is FunctionType -> functionTypedef(type)
        is UnresolvedType -> throw QuartzException("Unresolved type $type")
    }
}
