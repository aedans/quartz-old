package quartz.compiler.generator

import quartz.compiler.errors.QuartzException
import quartz.compiler.generator.program.*
import quartz.compiler.semantics.types.*
import quartz.compiler.util.Type

/**
 * Created by Aedan Smith.
 */

fun ProgramOutputStream.writeAll() {
    program.inlineCNodes.forEach { inlineC(it) }

    program.functionDeclarations.map { declare(FunctionType(it.value.function)) }
    program.structDeclarations.map { declare(StructType(it.value)) }
    program.typealiasDeclarationDeclarations.map { declare(AliasedType(it.value)) }

    program.structDeclarations.filterValues { !it.external }.forEach { structPrototype(it.value) }
    program.structDeclarations.filterValues { !it.external }.forEach { struct(it.value) }

    program.functionDeclarations.forEach { functionPrototype(it.value) }
    program.functionDeclarations.forEach { function(it.value) }
}

fun ProgramOutputStream.declare(type: Type) {
    when (type) {
        is StructType -> struct(program.structDeclarations[type.string]
                    ?: throw QuartzException("Unknown struct ${type.string}"))
        is AliasedType -> if (!type.external) typedef(type)
        is FunctionType -> functionTypedef(type)
        is UnresolvedType -> throw QuartzException("Unresolved type $type")
        is TemplateType -> throw QuartzException("Unexpected template $type")
    }
}
