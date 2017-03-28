package quartz.compiler.syntax.tree.struct

import quartz.compiler.util.types.StructType

/**
 * Created by Aedan Smith.
 */

class StructDeclarationNode(val name: String, val members: Map<String, StructMemberNode>) {
    val type = StructType(name, members.map { it.value.name to it.value.type }.toMap())

    override fun toString(): String {
        return "struct $name$members"
    }
}
