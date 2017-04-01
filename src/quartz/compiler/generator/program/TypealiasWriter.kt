package quartz.compiler.generator.program

import quartz.compiler.generator.ProgramOutputStream
import quartz.compiler.generator.declare
import quartz.compiler.generator.util.description
import quartz.compiler.generator.util.type
import quartz.compiler.util.types.FunctionType

/**
 * Created by Aedan Smith.
 */

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
