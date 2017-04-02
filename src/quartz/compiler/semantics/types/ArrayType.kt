package quartz.compiler.semantics.types

import quartz.compiler.util.Type

/**
 * Created by Aedan Smith.
 */

data class ArrayType(val type: Type) : Type {
    override fun canCastTo(type: Type): Boolean {
        return type == this
    }

    override fun toString(): String {
        return "$type[]"
    }
}
