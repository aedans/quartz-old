package quartz.compiler.generator.visitors.util

import quartz.compiler.util.Type
import quartz.compiler.util.types.ArrayType
import quartz.compiler.util.types.FunctionType
import quartz.compiler.util.types.Primitives
import quartz.compiler.util.types.StructType

/**
 * Created by Aedan Smith.
 */

fun Type.visit(string: StringBuilder) {
    when (this) {
        is ArrayType -> {
            type.visit(string)
            string.append('*')
        }
        is StructType -> {
            string.append("struct ")
            string.append(this)
        }
        is FunctionType -> {
            visitDescription(string)
            string.append("_t")
        }
        else -> string.append(this)
    }
}

fun Type.visitDescription(string: StringBuilder) {
    when (this) {
        is ArrayType -> {
            type.visitDescription(string)
            string.append("_array")
        }
        is StructType -> {
            this.toString().visitName(string)
        }
        is FunctionType -> {
            visitFunctionDescription(args, returnType, string)
        }
        else -> toString().visitName(string)
    }
}

fun visitFunctionDescription(args: List<Type>, returnType: Type, string: StringBuilder){
    when {
        args.isEmpty() && returnType == Primitives.void -> {
            string.append("process")
        }
        args.isEmpty() && returnType != Primitives.void -> {
            returnType.visitDescription(string)
            string.append("_supplier")
        }
        returnType == Primitives.void -> {
            args.forEach {
                it.visitDescription(string)
                string.append('_')
            }
            string.append("consumer")
        }
        else -> {
            args.forEach {
                it.visitDescription(string)
                string.append('_')
            }
            string.append("to_")
            returnType.visitDescription(string)
        }
    }
}
