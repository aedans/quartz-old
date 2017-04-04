package quartz.compiler.semantics.types

import quartz.compiler.syntax.tree.struct.StructDeclarationNode
import quartz.compiler.util.Type

/**
 * Created by Aedan Smith.
 */

class StructType(string: String, val structDeclarationNode: StructDeclarationNode, val external: Boolean) : Type(string, string) {
    override fun canCastTo(type: Type): Boolean {
        return type is StructType && type.string == this.string
    }

    override fun mapTypes(function: (Type?) -> Type?): Type {
        return StructType(string, structDeclarationNode, external)
    }
}
