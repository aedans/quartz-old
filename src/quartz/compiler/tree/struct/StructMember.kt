package quartz.compiler.tree.struct

import quartz.compiler.tree.util.Type

/**
 * Created by Aedan Smith.
 */

data class StructMember(val name: String, val type: Type) {
    override fun toString(): String {
        return "$name: $type"
    }
}
