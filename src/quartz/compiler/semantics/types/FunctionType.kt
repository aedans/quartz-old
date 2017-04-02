package quartz.compiler.semantics.types

import quartz.compiler.util.Function
import quartz.compiler.util.Type

/**
 * Created by Aedan Smith.
 */

data class FunctionType(val function: Function) : Type {
    override fun canCastTo(type: Type): Boolean {
        return type == this
    }

    override fun toString(): String {
        return function.toString()
    }
}
