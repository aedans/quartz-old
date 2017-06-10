package quartz.compiler.semantics.types

import quartz.compiler.tree.util.Type

/**
 * Created by Aedan Smith.
 */

object VoidType : Type {
    override val string = "void"
    override val descriptiveString get() = string

    override fun isSupertype(type: Type): Boolean {
        return type == this
    }

    override fun toString(): String {
        return string
    }
}
