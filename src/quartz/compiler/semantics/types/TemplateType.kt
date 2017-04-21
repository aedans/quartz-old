package quartz.compiler.semantics.types

import quartz.compiler.util.Type

/**
 * Created by Aedan Smith.
 */

data class TemplateType(override val string: String) : Type(string) {
    override fun mapTypes(function: (Type?) -> Type?): Type {
        return this
    }

    override fun isInstance(type: Type): Boolean {
        return type is TemplateType && type.string == this.string
    }
}
