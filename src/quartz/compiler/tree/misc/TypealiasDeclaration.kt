package quartz.compiler.tree.misc

import quartz.compiler.tree.GlobalDeclaration
import quartz.compiler.tree.util.Type

/**
 * Created by Aedan Smith.
 */

data class TypealiasDeclaration(val name: String, val aliasedType: Type) : GlobalDeclaration {
    override fun toString(): String {
        return "typealias $name = $aliasedType"
    }
}
