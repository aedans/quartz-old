package quartz.compiler.syntax.tree.struct

import quartz.compiler.util.Type

/**
 * Created by Aedan Smith.
 */

class StructMemberNode(val name: String, val type: Type, val mutable: Boolean) {
    override fun toString(): String {
        return "${if (mutable) "var" else "val"} $name: $type"
    }

    fun mapTypes(function: (Type?) -> Type?): StructMemberNode {
        return StructMemberNode(name, function(type.mapTypes(function))!!, mutable)
    }
}
