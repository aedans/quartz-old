package quartz.compiler.semantics.types

import quartz.compiler.util.Type

/**
 * Created by Aedan Smith.
 */

class NamedType(string: String, val templates: List<Type>) : Type(string, string) {
    override fun mapTypes(function: (Type?) -> Type?): Type {
        return NamedType(string, templates.map { function(it.mapTypes(function))!! })
    }

    override fun canCastTo(type: Type): Boolean {
        return type is NamedType
                && type.string == this.string
                && templates.size == type.templates.size
                && templates.zip(type.templates).all { it.first == it.second }
    }
}
