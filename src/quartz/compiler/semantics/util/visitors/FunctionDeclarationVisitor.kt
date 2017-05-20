package quartz.compiler.semantics.util.visitors

import quartz.compiler.errors.errorScope
import quartz.compiler.semantics.contexts.BlockContext
import quartz.compiler.semantics.contexts.FunctionDeclarationContext
import quartz.compiler.util.Visitor

/**
 * Created by Aedan Smith.
 */

fun Visitor<BlockContext>.functionDeclarationVisitor(): Visitor<FunctionDeclarationContext> {
    val blockVisitor = this
    return { functionDeclarationContext ->
        errorScope({ "function ${functionDeclarationContext.functionDeclaration.name}"}) {

            val (newBlock, newFunctionDeclarationContext) = blockVisitor(BlockContext(
                    functionDeclarationContext.functionDeclaration.block,
                    functionDeclarationContext,
                    emptyMap()
            ))

            newFunctionDeclarationContext as FunctionDeclarationContext

            newFunctionDeclarationContext.copy(
                    functionDeclaration = functionDeclarationContext.functionDeclaration.copy(
                            block = newBlock
                    )
            )
        }
    }
}
