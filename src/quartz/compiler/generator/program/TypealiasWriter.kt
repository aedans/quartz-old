package quartz.compiler.generator.program

import quartz.compiler.generator.ProgramOutputStream
import quartz.compiler.generator.declare
import quartz.compiler.generator.util.type
import quartz.compiler.semantics.types.FunctionType

/**
 * Created by Aedan Smith.
 */

// TODO migrate to visitor
fun ProgramOutputStream.functionTypedef(type: FunctionType) {
    (type.function.args ?: throw Exception("Unknown argument types for $type")).forEach {
        declare(it ?: throw Exception("Unknown argument type for $type"))
    }
    declare("typedef ${type.function}") {
        declare(type.function.returnType ?: throw Exception("Unknown return type for $type"))
        name("typedef")
        type(type.function.returnType)
        parentheses {
            string("*")
            string("__${type.descriptiveString}")
            string("_t")
        }
        parentheses {
            type.function.args.dropLast(1).forEach {
                type(it)
                string(", ")
            }
            if (type.function.args.isNotEmpty())
                type(type.function.args.last())
            if (type.function.vararg) {
                if (type.function.args.isNotEmpty())
                    string(", ")
                string("...")
            }
        }
        string(";")
        newline()
    }
}
