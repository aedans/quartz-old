package quartz.compiler.generator.program

import quartz.compiler.generator.ProgramOutputStream
import quartz.compiler.generator.declare
import quartz.compiler.generator.util.type
import quartz.compiler.semantics.types.AliasedType
import quartz.compiler.semantics.types.FunctionType

/**
 * Created by Aedan Smith.
 */

fun ProgramOutputStream.typedef(type: AliasedType) {
    declare("typedef_$type") {
        declare(type.type)
        name("typedef")
        type(type.type)
        name(type.string)
        string(";")
        newline()
    }
}

fun ProgramOutputStream.functionTypedef(type: FunctionType) {
    type.function.args!!.forEach {
        declare(it!!)
    }
    declare("typedef_${type.function}") {
        declare(type.function.returnType!!)
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
