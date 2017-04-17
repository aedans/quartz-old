package quartz.compiler.semantics.types

import quartz.compiler.util.Type

/**
 * Created by Aedan Smith.
 */

class TemplateType(string: String) : Type(string, string) {
    override fun mapTypes(function: (Type?) -> Type?): Type {
        return this
    }

    override fun isInstance(type: Type): Boolean {
        return type is TemplateType && type.string == this.string
    }
}
