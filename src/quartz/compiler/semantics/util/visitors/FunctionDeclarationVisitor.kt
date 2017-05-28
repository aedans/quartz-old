package quartz.compiler.semantics.util.visitors

import quartz.compiler.errors.errorScope
import quartz.compiler.tree.function.Block
import quartz.compiler.tree.function.FunctionDeclaration
import quartz.compiler.util.Visitor

/**
 * Created by Aedan Smith.
 */

fun Visitor<Block>.functionDeclarationVisitor(): Visitor<FunctionDeclaration> {
    val blockVisitor = this
    return { functionDeclaration ->
        errorScope({ "function ${functionDeclaration.name}"}) {
            functionDeclaration.copy(block = blockVisitor(functionDeclaration.block))
        }
    }
}
