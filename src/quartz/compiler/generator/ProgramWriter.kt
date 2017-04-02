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
    programNode.inlineCNodes.forEach { inlineC(it) }

    programNode.mapTypes { it?.apply { declare(this) } }

    programNode.structDeclarations.forEach { structPrototype(it) }
    programNode.structDeclarations.forEach { struct(it) }

    programNode.fnDeclarations.forEach { functionPrototype(it) }
    programNode.fnDeclarations.forEach { function(it) }
}

fun ProgramOutputStream.declare(type: Type) {
    when (type) {
        is StructType -> struct(programNode.structDeclarations.firstOrNull { it.name == type.name }
                ?: throw QuartzException("Unknown struct ${type.name}"))
        is AliasedType -> typedef(type)
        is FunctionType -> functionTypedef(type)
    }
}
