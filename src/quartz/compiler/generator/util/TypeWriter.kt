package quartz.compiler.generator.util

import quartz.compiler.generator.ProgramOutputStream
import quartz.compiler.semantics.types.ArrayType
import quartz.compiler.semantics.types.FunctionType
import quartz.compiler.semantics.types.Primitives
import quartz.compiler.semantics.types.StructType
import quartz.compiler.util.Function
import quartz.compiler.util.Type

/**
 * Created by Aedan Smith.
 */

fun ProgramOutputStream.type(type: Type) {
    when (type) {
        is ArrayType -> {
            type(type.type)
            string("*")
        }
        is StructType -> {
            name("struct")
            name(type.name)
        }
        is FunctionType -> {
            description(type)
            string("_t ")
        }
        else -> name(type)
    }
}

fun ProgramOutputStream.description(type: Type) {
    when (type) {
        is ArrayType -> {
            description(type.type)
            string("_array")
        }
        is FunctionType -> {
            functionDescription(type.function)
        }
        else -> string(type)
    }
}

fun ProgramOutputStream.functionDescription(function: Function){
    when {
        function.args.isEmpty() && function.returnType == Primitives.void -> {
            string("process")
        }
        function.args.isEmpty() && function.returnType != Primitives.void -> {
            description(function.returnType)
            string("_supplier")
        }
        function.returnType == Primitives.void -> {
            function.args.forEach {
                description(it)
                string('_')
            }
            string("consumer")
        }
        else -> {
            function.args.forEach {
                description(it)
                string('_')
            }
            string("to_")
            description(function.returnType)
        }
    }
    if (function.vararg)
        string("_vararg")
}
