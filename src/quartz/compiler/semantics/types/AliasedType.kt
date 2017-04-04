package quartz.compiler.semantics.types

import quartz.compiler.exceptions.QuartzException
import quartz.compiler.util.Type

/**
 * Created by Aedan Smith.
 */

class AliasedType(string: String, val type: Type, val external: Boolean) : Type(string, string, emptyList()) {
    override fun withTemplates(templates: List<Type>): Type {
        if (templates.isEmpty()) return this
        throw QuartzException("Templates are not allowed on $this")
    }

    override fun mapTypes(function: (Type?) -> Type?): Type {
        return AliasedType(string, function(type.mapTypes(function))!!, external)
    }

    override fun canCastTo(type: Type): Boolean {
        return type == this.type || type is AliasedType && type.string == this.string || type.canCastTo(type)
    }

    fun getTrueType(): Type {
        return (type as? AliasedType)?.getTrueType() ?: type
    }
}
