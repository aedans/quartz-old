package quartz.compiler.util.types

import quartz.compiler.util.Type

/**
 * Created by Aedan Smith.
 */

data class FunctionType(val args: List<Type>, val returnType: Type) : Type {
    override fun canCastTo(type: Type): Boolean {
        return type == this
    }

    override fun toString(): String {
        return "$args -> $returnType"
    }
}
