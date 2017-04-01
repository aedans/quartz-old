package quartz.compiler.generator.program

import quartz.compiler.generator.ProgramOutputStream
import quartz.compiler.generator.declare
import quartz.compiler.generator.util.type
import quartz.compiler.syntax.tree.struct.StructDeclarationNode
import quartz.compiler.syntax.tree.struct.StructMemberNode

/**
 * Created by Aedan Smith.
 */

fun ProgramOutputStream.struct(structDeclarationNode: StructDeclarationNode) {
    structDeclarationNode.members.forEach { declare(it.value.type) }
    declare("struct_${structDeclarationNode.name}") {
        margin {
            name("struct")
            name(structDeclarationNode.name)
            braces {
                structDeclarationNode.members.forEach { (_, member) ->
                    newline()
                    structMember(member)
                    string(";")
                }
            }
            string(";")
        }
    }
}

fun ProgramOutputStream.structPrototype(structDeclarationNode: StructDeclarationNode) {
    declare("structPrototype_${structDeclarationNode.name}") {
        name("struct")
        name(structDeclarationNode.name)
        string(";")
        newline()
    }
}

fun ProgramOutputStream.structMember(structMemberNode: StructMemberNode) {
    type(structMemberNode.type)
    name(structMemberNode.name)
}
