package quartz.compiler.semantics.consumers

import quartz.compiler.tree.GlobalDeclaration
import quartz.compiler.tree.function.FunctionDeclaration
import quartz.compiler.tree.misc.ExternFunctionDeclaration

/**
 * Created by Aedan Smith.
 */

interface GlobalDeclarationConsumer : FunctionDeclarationConsumer, ExternFunctionDeclarationConsumer {
    fun eat(globalDeclaration: GlobalDeclaration) {
        when (globalDeclaration) {
            is FunctionDeclaration -> eat(globalDeclaration)
            is ExternFunctionDeclaration -> eat(globalDeclaration)
            else -> throw Exception("Expected global declaration, found $globalDeclaration")
        }
    }
}
