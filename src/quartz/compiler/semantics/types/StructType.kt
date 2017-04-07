package quartz.compiler.semantics.types

import quartz.compiler.tree.struct.StructDeclaration
import quartz.compiler.util.Type

/**
 * Created by Aedan Smith.
 */

class StructType(
        string: String,
        val templates: List<Type>,
        val structDeclarationNode: StructDeclaration
) : Type(string, string) {
    val templateMap = structDeclarationNode.templates.zip(templates).toMap()
    val members = structDeclarationNode.members.mapValues { it.value.mapTypes { templateMap[it] ?: it } }

    fun withTemplates(templates: List<Type>): Type {
        return StructType(string, templates, structDeclarationNode)
    }

    override fun equals(other: Any?): Boolean {
        return other is StructType
                && other.string == this.string
                && templates.size == other.templates.size
                && templates.zip(other.templates).all { it.first == it.second }
    }

    override fun hashCode(): Int {
        return string.hashCode() + templates.hashCode()
    }

    override fun canCastTo(type: Type): Boolean {
        return type == this
    }

    override fun mapTypes(function: (Type?) -> Type?): StructType {
        return StructType(string, templates.map { function(it.mapTypes(function))!! }, structDeclarationNode)
    }
}
