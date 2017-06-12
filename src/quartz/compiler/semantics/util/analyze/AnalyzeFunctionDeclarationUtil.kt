package quartz.compiler.semantics.util.analyze

import quartz.compiler.tree.declarations.FunctionDeclaration
import quartz.compiler.tree.util.Type
import quartz.compiler.util.Visitor

/**
 * Created by Aedan Smith.
 */

inline fun FunctionDeclaration.visitTypes(typeVisitor: Visitor<Type>): FunctionDeclaration {
    return FunctionDeclaration(
            name,
            argNames,
            function.visitFunctionTypes(typeVisitor),
            block
    )
}
