package quartz.compiler.semantics.types

import quartz.compiler.tree.util.Type

/**
 * Created by Aedan Smith.
 */

data class ConstType(val type: Type) : Type("const_${type.descriptiveString}") {
    override val string = "const ${type.string}"

    override fun isSupertype(type: Type): Boolean {
        return type.isSupertype(this.type)
                || type is ConstType && this.type.isSupertype(type.type)
    }

    override fun toString(): String {
        return "Const($type)"
    }
}
