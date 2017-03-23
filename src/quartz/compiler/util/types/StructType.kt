package quartz.compiler.util.types

import quartz.compiler.util.Type

/**
 * Created by Aedan Smith.
 */

data class StructType(val name: String) : Type {
    override fun canCastTo(type: Type): Boolean {
        return type == this
    }

    override fun toString(): String {
        return name
    }
}
