package quartz.compiler.semantics.consumers

import quartz.compiler.tree.misc.ExternFunctionDeclaration

/**
 * Created by Aedan Smith.
 */

interface ExternFunctionDeclarationConsumer {
    fun eat(externFunctionDeclaration: ExternFunctionDeclaration)
}
