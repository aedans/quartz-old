package quartz.compiler.tree.struct

import quartz.compiler.semantics.types.StructType
import quartz.compiler.tree.GlobalDeclarationNode
import quartz.compiler.util.Type

/**
 * Created by Aedan Smith.
 */

data class StructDeclarationNode(
        val name: String,
        val templates: List<Type>,
        val members: Map<String, StructMemberNode>,
        val external: Boolean
) : GlobalDeclarationNode {
    val type = StructType(name, templates, this)

    override fun toString(): String {
        return "struct $name${if (templates.isNotEmpty()) "<$templates>" else ""}${members.values}"
    }

    fun mapTypes(function: (Type?) -> Type?): StructDeclarationNode {
        return StructDeclarationNode(
                name,
                templates.map { function(it.mapTypes(function))!! },
                members.map { it.key to it.value.mapTypes(function) }.toMap(),
                external
        )
    }
}