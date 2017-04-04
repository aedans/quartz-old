package quartz.compiler.semantics.types

import quartz.compiler.exceptions.QuartzException
import quartz.compiler.util.Type

/**
 * Created by Aedan Smith.
 */

class TemplateType(string: String) : Type(string, string, emptyList()) {
    override fun withTemplates(templates: List<Type>): TemplateType {
        if (templates.isEmpty()) return this
        throw QuartzException("Templates are not allowed on $this")
    }

    override fun mapTypes(function: (Type?) -> Type?): Type {
        return this
    }

    override fun canCastTo(type: Type): Boolean {
        return type is TemplateType && type.string == this.string
    }
}
