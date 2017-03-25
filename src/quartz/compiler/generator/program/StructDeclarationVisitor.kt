package quartz.compiler.generator.program

import quartz.compiler.generator.util.visit
import quartz.compiler.generator.util.visitName
import quartz.compiler.syntax.tree.program.struct.StructDeclarationNode
import quartz.compiler.syntax.tree.program.struct.StructMemberNode

/**
 * Created by Aedan Smith.
 */

fun StructDeclarationNode.visit(string: StringBuilder) {
    string.append("struct ")
    name.visitName(string)
    string.appendln('{')
    for ((_, declaration) in members) {
        string.append("    ")
        declaration.visit(string)
        string.appendln(';')
    }
    string.appendln("};").appendln()
}

fun StructDeclarationNode.visitPrototype(string: StringBuilder) {
    string.append("struct ")
    name.visitName(string)
    string.appendln(';')
}

fun StructMemberNode.visit(string: StringBuilder) {
    type.visit(string)
    string.append(' ')
    name.visitName(string)
}
