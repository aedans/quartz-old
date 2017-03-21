package quartz.compiler.generator.visitors

import quartz.compiler.generator.visitors.fndeclaration.visit
import quartz.compiler.generator.visitors.fndeclaration.visitPrototype
import quartz.compiler.syntax.tree.ProgramNode

/**
 * Created by Aedan Smith.
 */

fun ProgramNode.visit(string: StringBuilder) {
    fnDeclarations.forEach { it.visitPrototype(string) }
    inlineCNodes.forEach { it.visit(string) }
    fnDeclarations.forEach {
        string.appendln()
        it.visit(string)
    }
}
