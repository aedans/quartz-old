package quartz.compiler.tree.declarations

import quartz.compiler.tree.Type

/**
 * Created by Aedan Smith.
 */

data class TypealiasDeclaration(
        override val name: String,
        override val type: Type
) : TypeDeclaration {
    override fun toString(): String {
        return "typealias $name = $type"
    }
}
