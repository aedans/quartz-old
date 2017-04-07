package quartz.compiler.semantics.types

import quartz.compiler.util.Type

/**
 * Created by Aedan Smith.
 */

object Primitives {
    val char: Type = NumberType("char")
    val short: Type = NumberType("short")
    val int: Type = NumberType("int")
    val long: Type = NumberType("long")
    val float: Type = NumberType("float")
    val double: Type = NumberType("double")
    val void: Type = VoidType()
}

class NumberType(string: String) : Type(string, string) {
    override fun mapTypes(function: (Type?) -> Type?): Type {
        return this
    }

    override fun canCastTo(type: Type): Boolean {
        return type is NumberType
    }
}

class VoidType : Type("void", "void") {
    override fun mapTypes(function: (Type?) -> Type?): Type {
        return this
    }

    override fun canCastTo(type: Type): Boolean {
        return type is VoidType
    }
}
