package quartz.compiler.util

import quartz.compiler.tree.FnDeclarationNode

/**
 * Created by Aedan Smith.
 */

data class Function(val name: String, val args: List<Type>, val returnType: Type)

fun FnDeclarationNode.function(): Function {
    return Function(this.name, this.args.map { it.second }, this.returnType)
}
