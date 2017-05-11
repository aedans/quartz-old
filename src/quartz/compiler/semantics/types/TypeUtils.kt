package quartz.compiler.semantics.types

import quartz.compiler.tree.function.FunctionDeclaration
import quartz.compiler.tree.misc.ExternFunctionDeclaration
import quartz.compiler.tree.struct.StructDeclaration
import quartz.compiler.util.Function

/**
 * Created by Aedan Smith.
 */

fun FunctionDeclaration.type(): FunctionType {
    return function.type()
}

fun ExternFunctionDeclaration.type(): FunctionType {
    return function.type()
}

fun Function.type(): FunctionType {
    return FunctionType(this)
}

fun StructDeclaration.type(): StructType {
    return StructType(this)
}
