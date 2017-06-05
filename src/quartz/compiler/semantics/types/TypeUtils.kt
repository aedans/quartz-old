package quartz.compiler.semantics.types

import quartz.compiler.tree.declarations.FunctionDeclaration
import quartz.compiler.tree.declarations.ExternFunctionDeclaration
import quartz.compiler.tree.util.Function

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
