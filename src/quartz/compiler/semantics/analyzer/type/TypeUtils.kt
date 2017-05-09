package quartz.compiler.semantics.analyzer.type

import quartz.compiler.semantics.types.AliasedType
import quartz.compiler.semantics.types.FunctionType
import quartz.compiler.semantics.types.StructType
import quartz.compiler.util.Type

/**
 * Created by Aedan Smith.
 */

fun Type?.asStruct(): StructType? {
    return when (this) {
        is AliasedType -> type.asStruct()
        is StructType -> this
        else -> null
    }
}

fun Type?.asFunction(): FunctionType? {
    return when (this) {
        is AliasedType -> type.asFunction()
        is FunctionType -> this
        else -> null
    }
}
