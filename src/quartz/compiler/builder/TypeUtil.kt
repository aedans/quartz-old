package quartz.compiler.builder

import quartz.compiler.errors.err
import quartz.compiler.errors.errorScope
import quartz.compiler.parser.QuartzParser
import quartz.compiler.tree.Type
import quartz.compiler.tree.types.*

/**
 * Created by Aedan Smith.
 */

fun QuartzParser.TypeContext.toType(): Type {
    return errorScope({ "type $text" }) {
        when {
            atomicType() != null -> atomicType().toType()
            functionType() != null -> functionType().toType()
            else -> err { "Unknown type $text" }
        }
    }
}

fun QuartzParser.AtomicTypeContext.toType(): Type {
    return when {
        type() != null -> type().toType()
        NAME() != null -> NamedType(NAME().text)
        INLINE_C() != null -> InlineCType(INLINE_C().text.substring(2, INLINE_C().text.length - 2))
        primitiveType() != null -> primitiveType().toType()
        pointerType() != null -> pointerType().toType()
        constType() != null -> constType().toType()
        else -> err { "Unknown type $text" }
    }
}

fun QuartzParser.PrimitiveTypeContext.toType(): Type {
    return when {
        boolType != null -> BoolType
        charType != null -> CharType
        shortType != null -> ShortType
        intType != null -> IntType
        longType != null -> LongType
        ucharType != null -> UCharType
        ushortType != null -> UShortType
        uintType != null -> UIntType
        ulongType != null -> ULongType
        floatType != null -> FloatType
        doubleType != null -> DoubleType
        voidType != null -> VoidType
        else -> throw Exception("Unknown primitive type $text")
    }
}

fun QuartzParser.PointerTypeContext.toType(): Type {
    return PointerType(atomicType().toType())
}

fun QuartzParser.ConstTypeContext.toType(): Type {
    return ConstType(atomicType().toType())
}

fun QuartzParser.FunctionTypeContext.toType(): FunctionType {
    return FunctionType(
            atomicTypeList().toList(),
            type().toType(),
            vararg != null
    )
}