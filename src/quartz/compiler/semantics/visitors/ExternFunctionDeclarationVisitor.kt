package quartz.compiler.semantics.visitors

import quartz.compiler.tree.misc.ExternFunctionDeclaration
import quartz.compiler.tree.util.Type
import quartz.compiler.util.Visitor

/**
 * Created by Aedan Smith.
 */

object ExternFunctionDeclarationVisitor {
    inline fun visitTypes(
            typeVisitor: Visitor<Type>,
            externFunctionDeclaration: ExternFunctionDeclaration
    ): ExternFunctionDeclaration {
        return ExternFunctionDeclaration(
                externFunctionDeclaration.name,
                TypeVisitor.visitFunctionTypes(typeVisitor, externFunctionDeclaration.function)
        )
    }
}
