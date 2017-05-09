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

    override fun isEqualTo(type: Type): Boolean {
        return super.isEqualTo(type)
                || this.type.isEqualTo(type)
                || type is AliasedType && this.type.isEqualTo(type.type)
                || type is AliasedType && type.string == this.string
    }

    override fun isInstance(type: Type): Boolean {
        return type.isEqualTo(this)
                || this.type.isInstance(type)
                || type is AliasedType && this.type.isInstance(type.type)
    }

    override fun toString(): String {
        return "Aliased($string, $type)"
    }
}
