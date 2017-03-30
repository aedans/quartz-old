package quartz.compiler.util.types

import quartz.compiler.util.Function
import quartz.compiler.util.Type

/**
 * Created by Aedan Smith.
 */

data class FunctionType(val function: Function) : Type {
    override val canCastTo: (Type) -> Boolean = { it == this }

    override fun toString(): String {
        return function.toString()
    }
}
