package quartz.compiler.generator.visitors.struct

import quartz.compiler.generator.visitors.util.visitName
import quartz.compiler.syntax.tree.program.struct.StructDeclarationNode

/**
 * Created by Aedan Smith.
 */

fun StructDeclarationNode.visit(string: StringBuilder) {
    string.append("struct ")
    name.visitName(string)
    string.appendln('{')
    members.forEach {
        string.append("    ")
        it.visit(string)
        string.appendln(';')
    }
    string.appendln("};").appendln()
}

fun StructDeclarationNode.visitPrototype(string: StringBuilder) {
    string.append("struct ")
    name.visitName(string)
    string.appendln(';')
}
