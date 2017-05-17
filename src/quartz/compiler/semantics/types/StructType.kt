package quartz.compiler.semantics.types

import quartz.compiler.tree.struct.StructDeclaration
import quartz.compiler.tree.struct.StructMember
import quartz.compiler.tree.util.Type

/**
 * Created by Aedan Smith.
 */

data class StructType(
        override val string: String,
        val members: Map<String, StructMember>
) : Type(string) {
    constructor(structDeclaration: StructDeclaration) :
            this(structDeclaration.name, structDeclaration.members)

    override fun isInstance(type: Type): Boolean {
        return type == this
    }

    override fun toString(): String {
        return "Struct($string)"
    }
}
