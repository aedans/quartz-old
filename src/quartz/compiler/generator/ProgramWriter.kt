package quartz.compiler.generator

import quartz.compiler.errors.QuartzException
import quartz.compiler.generator.program.function
import quartz.compiler.generator.program.functionPrototype
import quartz.compiler.generator.program.functionTypedef
import quartz.compiler.generator.program.inlineC
import quartz.compiler.semantics.types.FunctionType
import quartz.compiler.semantics.types.NamedType
import quartz.compiler.tree.util.Type

/**
 * Created by Aedan Smith.
 */

fun ProgramOutputStream.writeAll() {
    program.inlineCDeclarations.forEach { inlineC(it) }

    program.externFunctionDeclarations.forEach { declare(FunctionType(it.value.function)) }
    program.functionDeclarations.forEach { declare(FunctionType(it.value.function)) }


    program.functionDeclarations.forEach { functionPrototype(it.value) }
    program.functionDeclarations.forEach { function(it.value) }
}

fun ProgramOutputStream.declare(type: Type) {
    when (type) {
        is FunctionType -> functionTypedef(type)
        is NamedType -> throw QuartzException("Unresolved type $type")
    }
}
