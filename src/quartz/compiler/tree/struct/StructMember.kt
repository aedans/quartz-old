package quartz.compiler.tree.struct

import quartz.compiler.util.Type

/**
 * Created by Aedan Smith.
 */

data class StructMember(val name: String, val type: Type, val mutable: Boolean) {
    override fun toString(): String {
        return "${if (mutable) "var" else "val"} $name: $type"
    }

    fun mapTypes(function: (Type?) -> Type?): StructMember {
        return StructMember(name, function(type.mapTypes(function))!!, mutable)
    }
}
