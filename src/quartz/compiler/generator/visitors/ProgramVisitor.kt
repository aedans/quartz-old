package quartz.compiler.generator.visitors

import quartz.compiler.generator.visitors.fndeclaration.visit
import quartz.compiler.generator.visitors.fndeclaration.visitPrototype
import quartz.compiler.generator.visitors.struct.visit
import quartz.compiler.syntax.tree.ProgramNode

/**
 * Created by Aedan Smith.
 */

fun ProgramNode.visit(string: StringBuilder) {
    structDeclarations.forEach { it.visit(string) }
    fnDeclarations.sortedBy { it.returnType.toString() }.forEach { it.visitPrototype(string) }
    inlineCNodes.forEach { it.visit(string) }
    fnDeclarations.forEach {
        string.appendln()
        it.visit(string)
    }
}
