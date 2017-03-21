package quartz.compiler.generator.visitors.struct

import quartz.compiler.generator.visitors.util.visit
import quartz.compiler.generator.visitors.util.visitName
import quartz.compiler.syntax.tree.program.struct.StructMemberNode

/**
 * Created by Aedan Smith.
 */

fun StructMemberNode.visit(string: StringBuilder) {
    type.visit(string)
    string.append(' ')
    name.visitName(string)
}
