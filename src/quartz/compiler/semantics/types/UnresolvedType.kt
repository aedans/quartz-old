package quartz.compiler.semantics.types

import quartz.compiler.util.Type

/**
 * Created by Aedan Smith.
 */

data class UnresolvedType(override val string: String, val templates: List<Type>) : Type({
    var s = string
    templates.forEach { s += '_' + it.descriptiveString }
    s
}()) {
    override fun mapTypes(function: (Type?) -> Type?): Type {
        return UnresolvedType(string, templates.map { function(it.mapTypes(function))!! })
    }

    override fun isInstance(type: Type): Boolean {
        return type is UnresolvedType && type.string == this.string
    }

    override fun toString(): String {
        return string +
                if (templates.isNotEmpty()) templates.joinToString(prefix = "<", postfix = ">") { it.toString() } else ""
    }
}
