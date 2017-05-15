package quartz.compiler.generator.program

import quartz.compiler.generator.ProgramOutputStream
import quartz.compiler.generator.declare
import quartz.compiler.generator.util.type
import quartz.compiler.tree.struct.StructDeclaration
import quartz.compiler.tree.struct.StructMember

/**
 * Created by Aedan Smith.
 */

fun ProgramOutputStream.struct(structDeclarationNode: StructDeclaration) {
    if (structDeclarationNode.external)
        return
    declare("struct ${structDeclarationNode.name}") {
        structDeclarationNode.members.forEach { declare(it.value.type) }
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

fun ProgramOutputStream.structPrototype(structDeclarationNode: StructDeclaration) {
    declare("struct prototype ${structDeclarationNode.name}") {
        name("struct")
        name(structDeclarationNode.name)
        string(";")
        newline()
    }
}

fun ProgramOutputStream.structMember(structMember: StructMember) {
    type(structMember.type)
    name(structMember.name)
}
