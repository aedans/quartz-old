package quartz.compiler.syntax.tree.program.struct

import quartz.compiler.util.types.StructType

/**
 * Created by Aedan Smith.
 */

class StructDeclarationNode(val name: String, val members: List<StructMemberNode>) {
    val type = StructType(name)

    override fun toString(): String {
        return "struct $name$members"
    }
}
