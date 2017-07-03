package quartz.compiler.tree

import quartz.compiler.tree.util.Type

/**
 * Created by Aedan Smith.
 */

interface VariableDeclaration : Declaration {
    val type: Type
}
