package quartz.compiler.tree.declarations

import quartz.compiler.tree.Declaration
import quartz.compiler.tree.util.Type

/**
 * Created by Aedan Smith.
 */

data class TypealiasDeclaration(override val name: String, val aliasedType: Type) : Declaration {
    override fun toString(): String {
        return "typealias $name = $aliasedType"
    }
}
