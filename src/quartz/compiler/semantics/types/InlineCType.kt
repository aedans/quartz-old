package quartz.compiler.semantics.types

import quartz.compiler.tree.util.Type

/**
 * Created by Aedan Smith.
 */

data class InlineCType(override val string: String) : Type(string) {
    override fun isSupertype(type: Type): Boolean {
        return true
    }

    override fun toString(): String {
        return "%%$string%%"
    }
}
