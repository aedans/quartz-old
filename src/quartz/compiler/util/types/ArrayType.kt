package quartz.compiler.util.types

import quartz.compiler.util.Type

/**
 * Created by Aedan Smith.
 */

data class ArrayType(val type: Type) : Type {
    override val canCastTo: (Type) -> Boolean = { it == this }

    override fun toString(): String {
        return "$type[]"
    }
}
