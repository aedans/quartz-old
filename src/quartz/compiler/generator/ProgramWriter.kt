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

    programNode.structDeclarations.filterValues { !it.external }.forEach { structPrototype(it.value) }
    programNode.structDeclarations.filterValues { !it.external }.forEach { struct(it.value) }

    programNode.fnDeclarations.forEach { functionPrototype(it.value) }
    programNode.fnDeclarations.forEach { function(it.value) }
}

fun ProgramOutputStream.declare(type: Type) {
    when (type) {
        is StructType -> if (!type.structDeclarationNode.external)
            struct(programNode.structDeclarations[type.string]
                    ?: throw QuartzException("Unknown struct $type"))
        is AliasedType -> if (!type.external) typedef(type)
        is FunctionType -> functionTypedef(type)
//        is TemplateType -> throw QuartzException("Unexpected template $type")
    }
}
