package quartz.compiler.syntax.tree.struct

import quartz.compiler.semantics.types.StructType
import quartz.compiler.syntax.tree.GlobalDeclarationNode
import quartz.compiler.util.Type

/**
 * Created by Aedan Smith.
 */

class StructDeclarationNode(
        val name: String,
        val members: Map<String, StructMemberNode>,
        val external: Boolean
) : GlobalDeclarationNode {
    val type by lazy {
        StructType(name, members.map { it.value.name to it.value.type }.toMap(), external)
    }

    override fun toString(): String {
        return "struct $name$members"
    }

    fun mapTypes(function: (Type?) -> Type?): StructDeclarationNode {
        return StructDeclarationNode(
                name,
                members.map { it.key to it.value.mapTypes(function) }.toMap(),
                external
        )
    }
}