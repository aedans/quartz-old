package quartz.compiler.tree.types

import quartz.compiler.tree.Type

/**
 * Created by Aedan Smith.
 */

sealed class NumberType(val string: String) : Type {
    override fun isConvertibleTo(type: Type): Boolean {
        return type is NumberType
    }

    override fun toString(): String {
        return string
    }
}

object BoolType : NumberType("_Bool")
object CharType : NumberType("char")
object ShortType : NumberType("short")
object IntType : NumberType("int")
object LongType : NumberType("long long")
object UCharType : NumberType("unsigned char")
object UShortType : NumberType("unsigned short")
object UIntType : NumberType("unsigned int")
object ULongType : NumberType("unsigned long long")
object FloatType : NumberType("float")
object DoubleType : NumberType("double")
