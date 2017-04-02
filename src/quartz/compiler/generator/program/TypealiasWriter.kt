package quartz.compiler.generator.program

import quartz.compiler.generator.ProgramOutputStream
import quartz.compiler.generator.declare
import quartz.compiler.generator.util.description
import quartz.compiler.generator.util.type
import quartz.compiler.semantics.types.AliasedType
import quartz.compiler.semantics.types.FunctionType

/**
 * Created by Aedan Smith.
 */

fun ProgramOutputStream.typedef(type: AliasedType) {
    declare(type.type)
    declare("typedef_${type.name}") {
        name("typedef")
        type(type.type)
        name(type.name)
        string(";")
        newline()
    }
}

fun ProgramOutputStream.functionTypedef(type: FunctionType) {
    type.function.args.forEach { declare(it) }
    declare(type.function.returnType)
    declare("typedef_${type.function}") {
        name("typedef")
        type(type.function.returnType)
        parentheses {
            string("*")
            description(type)
            string("_t")
        }
        parentheses {
            type.function.args.dropLast(1).forEach {
                type(it)
                string(", ")
            }
            if (type.function.args.isNotEmpty())
                type(type.function.args.last())
        }
        string(";")
        newline()
    }
}
