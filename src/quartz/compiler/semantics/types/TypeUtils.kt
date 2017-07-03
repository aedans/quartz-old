package quartz.compiler.semantics.types

import quartz.compiler.tree.declarations.ExternFunctionDeclaration
import quartz.compiler.tree.declarations.FunctionDeclaration

/**
 * Created by Aedan Smith.
 */

fun FunctionDeclaration.type(): FunctionType {
    return FunctionType(argTypes, returnType, false)
}

fun ExternFunctionDeclaration.type(): FunctionType {
    return FunctionType(args, returnType, vararg)
}
