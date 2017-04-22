package quartz.compiler.semantics.types

import quartz.compiler.tree.struct.StructMember
import quartz.compiler.util.Type

/**
 * Created by Aedan Smith.
 */

data class StructType(
        override val string: String,
        val members: Map<String, StructMember>
) : Type(string) {
    override fun isInstance(type: Type): Boolean {
        return type == this
    }

    override fun mapTypes(function: (Type?) -> Type?): StructType {
        return StructType(
                string,
                members.filterValues { it.type != this }.mapValues { it.value.mapTypes(function) }
        )
    }

    override fun toString(): String {
        return string
    }
}
