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

    programNode.structDeclarations.filter { !it.external }.forEach { structPrototype(it) }
    programNode.structDeclarations.filter { !it.external }.forEach { struct(it) }

    programNode.fnDeclarations.forEach { functionPrototype(it) }
    programNode.fnDeclarations.forEach { function(it) }
}

fun ProgramOutputStream.declare(type: Type) {
    when (type) {
        is StructType -> if (!type.external) struct(programNode.structDeclarations.firstOrNull { it.name == type.string }
                ?: throw QuartzException("Unknown struct $type"))
        is AliasedType -> if (!type.external) typedef(type)
        is FunctionType -> functionTypedef(type)
//        is TemplateType -> throw QuartzException("Unexpected template $type")
    }
}
