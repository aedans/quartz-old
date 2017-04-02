package quartz.compiler.semantics.types

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
    val void: Type = QVoid()
}

private data class NumType(val string: String) : Type {
    override fun mapTypes(function: (Type?) -> Type?): Type {
        return this
    }

    override fun canCastTo(type: Type): Boolean {
        return type is NumType
    }

    override fun toString(): String {
        return string
    }
}

private class QVoid : Type {
    override fun mapTypes(function: (Type?) -> Type?): Type {
        return this
    }

    override fun canCastTo(type: Type): Boolean {
        return type is QVoid
    }

    override fun toString(): String {
        return "void"
    }
}
