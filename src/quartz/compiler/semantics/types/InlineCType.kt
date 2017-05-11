package quartz.compiler.semantics.types

import quartz.compiler.util.Type

/**
 * Created by Aedan Smith.
 */

data class InlineCType(override val string: String) : Type(string) {
    override fun isInstance(type: Type): Boolean {
        return true
    }

    override fun toString(): String {
        return "%%$string%%"
    }
}
