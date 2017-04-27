package quartz.compiler.semantics.types

import quartz.compiler.util.Type

/**
 * Created by Aedan Smith.
 */

data class ConstType(val type: Type) : Type("const_${type.descriptiveString}") {
    override val string = "const $type"

    override fun mapTypes(function: (Type?) -> Type?): Type {
        return ConstType(function(type.mapTypes(function))!!)
    }

    override fun isInstance(type: Type): Boolean {
        return type.isInstance(this.type)
                || type is ConstType && this.type.isInstance(type.type)
    }

    override fun toString(): String {
        return string
    }
}
