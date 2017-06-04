package quartz.compiler.semantics.visitors

import quartz.compiler.tree.function.FunctionDeclaration
import quartz.compiler.tree.util.Type
import quartz.compiler.util.Visitor

/**
 * Created by Aedan Smith.
 */

object FunctionDeclarationVisitor {
    inline fun visitTypes(typeVisitor: Visitor<Type>, functionDeclaration: FunctionDeclaration): FunctionDeclaration {
        return FunctionDeclaration(
                functionDeclaration.name,
                functionDeclaration.argNames,
                TypeVisitor.visitFunctionTypes(typeVisitor, functionDeclaration.function),
                functionDeclaration.block
        )
    }
}
