package quartz.compiler.syntax.tree.program.struct

import quartz.compiler.util.Type

/**
 * Created by Aedan Smith.
 */

class StructMemberNode(val name: String, val type: Type, val mutable: Boolean) {
    override fun toString(): String {
        return "${if (mutable) "var" else "val"} $name: $type"
    }
}
