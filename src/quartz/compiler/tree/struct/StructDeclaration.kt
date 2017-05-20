package quartz.compiler.tree.struct

import quartz.compiler.tree.GlobalDeclaration

/**
 * Created by Aedan Smith.
 */

data class StructDeclaration(
        val name: String,
        val members: Map<String, StructMember>,
        val generics: List<String>,
        val external: Boolean
) : GlobalDeclaration {
    override fun toString(): String {
        return "struct $name" +
                generics.joinToString(prefix = "<", postfix = ">") +
                members.values.joinToString(prefix = "{\n\t", postfix = "\n}", separator = "\n\t")
    }
}