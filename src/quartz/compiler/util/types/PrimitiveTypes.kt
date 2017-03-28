package quartz.compiler.util.types

import quartz.compiler.util.Type

/**
 * Created by Aedan Smith.
 */

object Primitives {
    val char: Type = NumType("char")
    val short: Type = NumType("short")
    val int: Type = NumType("int")
    val long: Type = NumType("long")
    val float: Type = NumType("float")
    val double: Type = NumType("double")
    val bool: Type = int
    val void: Type = QVoid()
}

private class NumType(val string: String) : Type {
    override val canCastTo: (Type) -> Boolean = { it is NumType }

    override fun toString(): String {
        return string
    }
}

private class QVoid : Type {
    override val canCastTo: (Type) -> Boolean = { it is QVoid }

    override fun toString(): String {
        return "void"
    }
}
