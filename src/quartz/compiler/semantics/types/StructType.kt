package quartz.compiler.semantics.types

import quartz.compiler.tree.struct.StructDeclaration
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
    constructor(structDeclaration: StructDeclaration) :
            this(structDeclaration.name, structDeclaration.templates, structDeclaration.members)

    override fun isInstance(type: Type): Boolean {
        return type == this
    }

    override fun mapTypes(function: (Type?) -> Type?): StructType {
        return copy(
                templates = templates.map { function(it.mapTypes(function))!! },
                members = members.filterValues { it.type != this }.mapValues { it.value.mapTypes(function) }
        )
    }

    override fun toString(): String {
        return string +
                if (templates.isNotEmpty()) templates.joinToString(prefix = "<", postfix = ">") { it.toString() } else ""
    }
}
