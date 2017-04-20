package quartz.compiler.semantics.types

import quartz.compiler.tree.struct.StructMember
import quartz.compiler.util.Type

/**
 * Created by Aedan Smith.
 */

class StructType(
        string: String,
        val templates: List<Type>,
        val members: Map<String, StructMember>
) : Type(string, {
    var s = string
    templates.forEach { s += '_' + it.descriptiveString }
    s
}()) {
    fun withTemplates(templates: List<Type>): Type {
        val templateMap = this.templates.zip(templates).toMap()
        return StructType(string, templates, members.mapValues { it.value.mapTypes { templateMap[it] ?: it } })
    }

    override fun equals(other: Any?): Boolean {
        return other is StructType
                && other.string == this.string
                && templates.size == other.templates.size
                && templates.zip(other.templates).all { it.first == it.second }
    }

    override fun hashCode(): Int {
        return string.hashCode() * templates.hashCode()
    }

    override fun isInstance(type: Type): Boolean {
        return type == this
    }

    override fun mapTypes(function: (Type?) -> Type?): StructType {
        return StructType(
                string,
                templates.map { function(it.mapTypes(function))!! },
                members.filterValues { it.type != this }.mapValues { it.value.mapTypes(function) }
        )
    }

    override fun toString(): String {
        return "$string${if (templates.isNotEmpty()) templates.joinToString(prefix = "<", postfix = ">") { it.toString() } else ""}"
    }
}
