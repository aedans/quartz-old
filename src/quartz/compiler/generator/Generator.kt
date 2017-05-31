package quartz.compiler.generator

import quartz.compiler.tree.GlobalDeclaration
import quartz.compiler.tree.function.FunctionDeclaration
import quartz.compiler.tree.misc.ExternFunctionDeclaration
import quartz.compiler.tree.misc.InlineC

/**
 * Created by Aedan Smith.
 */

interface Generator {
    fun declare(globalDeclaration: GlobalDeclaration)
    fun isDeclared(globalDeclaration: GlobalDeclaration): Boolean

    fun generate(functionDeclaration: FunctionDeclaration)
    fun generate(externFunctionDeclaration: ExternFunctionDeclaration)
    fun generate(inlineC: InlineC)
}
