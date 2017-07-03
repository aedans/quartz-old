package quartz.compiler.tree

import quartz.compiler.tree.util.Type

/**
 * Created by Aedan Smith.
 */

interface TypeDeclaration : Declaration {
    val type: Type
}
