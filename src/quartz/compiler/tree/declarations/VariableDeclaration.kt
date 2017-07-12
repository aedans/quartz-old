package quartz.compiler.tree.declarations

import quartz.compiler.tree.Declaration
import quartz.compiler.tree.Type

/**
 * Created by Aedan Smith.
 */

interface VariableDeclaration : Declaration {
    val type: Type
}
