package quartz.compiler.tree.struct

import quartz.compiler.semantics.types.StructType
import quartz.compiler.tree.GlobalDeclaration
import quartz.compiler.util.Type

/**
 * Created by Aedan Smith.
 */

data class StructDeclaration(
        val name: String,
        val templates: List<Type>,
        val members: Map<String, StructMember>,
        val external: Boolean
) : GlobalDeclaration {
    val type = StructType(name, templates, this)

    override fun toString(): String {
        return "struct $name${if (templates.isNotEmpty()) "<$templates>" else ""}${members.values}"
    }

    fun mapTypes(function: (Type?) -> Type?): StructDeclaration {
        return StructDeclaration(
                name,
                templates.map { function(it.mapTypes(function))!! },
                members.map { it.key to it.value.mapTypes(function) }.toMap(),
                external
        )
    }
}