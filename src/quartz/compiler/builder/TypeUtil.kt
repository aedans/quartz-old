package quartz.compiler.builder

import quartz.compiler.errors.errorScope
import quartz.compiler.parser.QuartzParser
import quartz.compiler.tree.types.*
import quartz.compiler.tree.Type

/**
 * Created by Aedan Smith.
 */

fun QuartzParser.TypeContext.toType(): Type {
    return errorScope({ "variableType $text" }) {
        when {
            NAME() != null -> NamedType(NAME().text)
            INLINE_C() != null -> InlineCType(INLINE_C().text.substring(2, INLINE_C().text.length-2))
            primitiveType() != null -> primitiveType().toType()
            functionType() != null -> functionType().toType()
            pointerType() != null -> pointerType().toType()
            constType() != null -> constType().toType()
            else -> throw Exception("Unknown type $text")
        }
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

fun QuartzParser.FunctionTypeContext.toType(): FunctionType {
    return FunctionType(
            args.toList(),
            returnType.toType(),
            args.isVararg()
    )
}

fun QuartzParser.PointerTypeContext.toType(): Type {
    return PointerType(type().toType())
}

fun QuartzParser.ConstTypeContext.toType(): Type {
    return ConstType(type().toType())
}
