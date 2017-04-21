package quartz.compiler.semantics.types

import quartz.compiler.util.Type

/**
 * Created by Aedan Smith.
 */

object Primitives {
    val char: Type = NumberType("char")
    val short: Type = NumberType("short")
    val int: Type = NumberType("int")
    val long: Type = NumberType("long long")
    val uchar: Type = NumberType("unsigned char")
    val ushort: Type = NumberType("unsigned short")
    val uint: Type = NumberType("unsigned int")
    val ulong: Type = NumberType("unsigned long long")
    val float: Type = NumberType("float")
    val double: Type = NumberType("double")
    val void: Type = VoidType()
}

class NumberType(override val string: String) : Type(string.replace(' ', '_')) {
    override fun mapTypes(function: (Type?) -> Type?): Type {
        return this
    }

    override fun isInstance(type: Type): Boolean {
        return type is NumberType
    }
}

class VoidType : Type("void") {
    override val string = "void"

    override fun mapTypes(function: (Type?) -> Type?): Type {
        return this
    }

    override fun isInstance(type: Type): Boolean {
        return type == this
    }
}
