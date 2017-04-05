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

fun ProgramOutputStream.structPrototype(structDeclarationNode: StructDeclaration) {
    declare("structPrototype_${structDeclarationNode.name}") {
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
