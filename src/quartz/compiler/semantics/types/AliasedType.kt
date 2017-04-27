package quartz.compiler.semantics.types

import quartz.compiler.tree.misc.TypealiasDeclaration
import quartz.compiler.util.Type

/**
 * Created by Aedan Smith.
 */

data class AliasedType(
        override val string: String,
        val type: Type,
        val external: Boolean
) : Type(string) {
    constructor(typealiasDeclaration: TypealiasDeclaration) :
            this(typealiasDeclaration.name, typealiasDeclaration.aliasedType, typealiasDeclaration.external)

    override fun mapTypes(function: (Type?) -> Type?): Type {
        return AliasedType(string, function(type.mapTypes(function))!!, external)
    }

    override fun isEqualTo(type: Type): Boolean {
        return super.isEqualTo(type) || type.isEqualTo(this.type)
    }

    override fun isInstance(type: Type): Boolean {
        return type == this.type
                || this.type.isInstance(type)
                || type.isInstance(this.type)
                || type is AliasedType && type.string == this.string
                || type is AliasedType && this.type.isInstance(type.type)
    }

    override fun toString(): String {
        return string
    }
}
