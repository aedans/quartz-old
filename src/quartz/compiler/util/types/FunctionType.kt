package quartz.compiler.util.types

import quartz.compiler.util.Type

/**
 * Created by Aedan Smith.
 */

data class FunctionType(val args: List<Type>, val returnType: Type, val vararg: Boolean) : Type {
    override val canCastTo: (Type) -> Boolean = { it == this }

    override fun toString(): String {
        return "$args${if (vararg) "..." else ""} -> $returnType"
    }
}
