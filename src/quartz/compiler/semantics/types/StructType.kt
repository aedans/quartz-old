package quartz.compiler.semantics.types

import quartz.compiler.tree.struct.StructMember
import quartz.compiler.util.Type

/**
 * Created by Aedan Smith.
 */

data class StructType(
        override val string: String,
        val templates: List<Type>,
        val members: Map<String, StructMember>
) : Type({
    var s = string
    templates.forEach { s += '_' + it.descriptiveString }
    s
}()) {
    fun withTemplates(templates: List<Type>): Type {
        val templateMap = this.templates.map(Type::string).zip(templates).toMap()
        return StructType(string, templates, members.mapValues { it.value.mapTypes { templateMap[it?.string] ?: it } })
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
