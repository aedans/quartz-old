package quartz.compiler.tree.struct

import quartz.compiler.tree.GlobalDeclaration
import quartz.compiler.util.Type

/**
 * Created by Aedan Smith.
 */

data class StructDeclaration(
        val name: String,
        val members: Map<String, StructMember>,
        val external: Boolean
) : GlobalDeclaration {
    override fun toString(): String {
        return "struct $name" + members.values.joinToString(prefix = "{\n\t", postfix = "\n}", separator = "\n\t")
    }

    fun mapTypes(function: (Type?) -> Type?): StructDeclaration {
        return copy(members = members.map { it.key to it.value.mapTypes(function) }.toMap())
    }
}