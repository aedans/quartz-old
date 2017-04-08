package quartz.compiler.generator

import quartz.compiler.exceptions.QuartzException
import quartz.compiler.generator.program.*
import quartz.compiler.semantics.types.AliasedType
import quartz.compiler.semantics.types.FunctionType
import quartz.compiler.semantics.types.StructType
import quartz.compiler.util.Type

/**
 * Created by Aedan Smith.
 */

fun ProgramOutputStream.writeAll() {
    program.inlineCNodes.forEach { inlineC(it) }

    program.mapTypes { it?.apply { declare(this) } }

    program.structDeclarations.filterValues { !it.external }.forEach { structPrototype(it.value) }
    program.structDeclarations.filterValues { !it.external }.forEach { struct(it.value) }

    program.functionDeclarations.forEach { functionPrototype(it.value) }
    program.functionDeclarations.forEach { function(it.value) }
}

fun ProgramOutputStream.declare(type: Type) {
    when (type) {
        is StructType -> struct(program.structDeclarations[type.string]
                    ?: throw QuartzException("Unknown struct $type"))
        is AliasedType -> if (!type.external) typedef(type)
        is FunctionType -> functionTypedef(type)
//        is TemplateType -> throw QuartzException("Unexpected template $type")
    }
}
