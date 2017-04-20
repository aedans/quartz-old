package quartz.compiler.tree.struct

import quartz.compiler.semantics.types.StructType
import quartz.compiler.semantics.types.TemplateType
import quartz.compiler.tree.GlobalDeclaration
import quartz.compiler.util.Type

/**
 * Created by Aedan Smith.
 */

data class StructDeclaration(
        val name: String,
        val templates: List<TemplateType>,
        val members: Map<String, StructMember>,
        val external: Boolean
) : GlobalDeclaration {
    val type = StructType(name, templates, members)

    override fun toString(): String {
        return "struct $name" +
                (if (templates.isNotEmpty()) templates.joinToString(prefix = "<", postfix = ">") { it.toString() } else "") +
                members.values.joinToString(prefix = "{\n\t", postfix = "\n}", separator = "\n\t") { it.toString() }
    }

    fun mapTypes(function: (Type?) -> Type?): StructDeclaration {
        return StructDeclaration(
                name,
                templates,
                members.map { it.key to it.value.mapTypes(function) }.toMap(),
                external
        )
    }
}