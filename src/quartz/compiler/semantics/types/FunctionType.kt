package quartz.compiler.semantics.types

import quartz.compiler.exceptions.QuartzException
import quartz.compiler.util.Function
import quartz.compiler.util.Type

/**
 * Created by Aedan Smith.
 */

data class FunctionType(val function: Function) : Type("$function", function.description(), emptyList()) {
    override fun withTemplates(templates: List<Type>): Type {
        if (templates.isEmpty()) return this
        throw QuartzException("Templates are not allowed on $this")
    }

    override fun mapTypes(function: (Type?) -> Type?): Type {
        return FunctionType(this.function.mapTypes(function))
    }

    override fun canCastTo(type: Type): Boolean {
        return type is FunctionType
                && type.function.args.zip(function.args).all { canCast(it.first, it.second) }
                && type.function.returnType.canCastTo(function.returnType)
                && type.function.vararg == function.vararg
    }

    override fun toString(): String {
        return string
    }
}

private fun Function.description(): String {
    var string = ""
    when {
        args.isEmpty() && returnType == Primitives.void -> {
            string += "process"
        }
        args.isEmpty() && returnType != Primitives.void -> {
            string += returnType.descriptiveString + "_supplier"
        }
        returnType == Primitives.void -> {
            args.forEach { string += it.descriptiveString + '_' }
            string += "consumer"
        }
        else -> {
            args.forEach { string += it.descriptiveString + '_' }
            string += "to_"
            string += returnType.descriptiveString
        }
    }
    if (vararg)
        string += "_vararg"

    return string
}
