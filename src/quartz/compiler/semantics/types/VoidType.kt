package quartz.compiler.semantics.types

import quartz.compiler.tree.util.Type

/**
 * Created by Aedan Smith.
 */

object VoidType : Type("void") {
    override val string = "void"

    override fun isInstance(type: Type): Boolean {
        return true
    }

    override fun toString(): String {
        return string
    }
}
