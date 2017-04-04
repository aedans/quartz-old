package quartz.compiler.semantics.types

import quartz.compiler.syntax.tree.struct.StructDeclarationNode
import quartz.compiler.util.Type

/**
 * Created by Aedan Smith.
 */

class StructType(
        string: String,
        templates: List<Type>,
        val structDeclarationNode: StructDeclarationNode
) : Type(string, string, templates) {
    val templateMap = structDeclarationNode.templates.zip(templates).toMap()
    val members = structDeclarationNode.members.mapValues { it.value.mapTypes { templateMap[it] ?: it } }

    override fun withTemplates(templates: List<Type>): Type {
        return StructType(string, templates, structDeclarationNode)
    }

    override fun canCastTo(type: Type): Boolean {
        return type is StructType
                && type.string == this.string
                && templates.size == type.templates.size
                && templates.zip(type.templates).all { Type.canCast(it.first, it.second) }
    }

    override fun mapTypes(function: (Type?) -> Type?): StructType {
        return StructType(string, templates.map { function(it.mapTypes(function))!! }, structDeclarationNode)
    }
}
