package quartz.compiler.semantics.util.analyze

import quartz.compiler.tree.declarations.ExternFunctionDeclaration
import quartz.compiler.tree.util.Type
import quartz.compiler.util.Visitor

/**
 * Created by Aedan Smith.
 */

inline fun ExternFunctionDeclaration.visitTypes(typeVisitor: Visitor<Type>): ExternFunctionDeclaration {
    return ExternFunctionDeclaration(name, function.visitFunctionTypes(typeVisitor))
}
