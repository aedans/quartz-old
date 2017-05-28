package quartz.compiler.semantics.consumers

import quartz.compiler.tree.function.FunctionDeclaration

/**
 * Created by Aedan Smith.
 */

interface FunctionDeclarationConsumer {
    fun eat(functionDeclaration: FunctionDeclaration)
}
