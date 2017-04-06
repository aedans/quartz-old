package quartz.compiler.semantics.types

import quartz.compiler.util.Type

/**
 * Created by Aedan Smith.
 */

data class ArrayType(val type: Type) : Type("$type[]", "${type.descriptiveString}_array") {
    override fun mapTypes(function: (Type?) -> Type?): Type {
        return ArrayType(function(type.mapTypes(function))!!)
    }

    override fun canCastTo(type: Type): Boolean {
        return type is ArrayType && type.type == type
    }

    override fun toString(): String {
        return string
    }
}
