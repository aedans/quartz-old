package quartz.compiler.semantics.types

import quartz.compiler.util.Type

/**
 * Created by Aedan Smith.
 */

class UnresolvedType(override val string: String, val templates: List<Type>) : Type({
    var s = string
    templates.filter { it !is TemplateType }.forEach { s += '_' + it.descriptiveString }
    s
}()) {
    override fun mapTypes(function: (Type?) -> Type?): Type {
        return UnresolvedType(string, templates.map { function(it.mapTypes(function))!! })
    }

    override fun isInstance(type: Type): Boolean {
        return type is UnresolvedType
                && type.string == this.string
                && templates.size == type.templates.size
                && templates.zip(type.templates).all { it.first == it.second }
    }
}
