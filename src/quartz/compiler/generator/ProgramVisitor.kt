package quartz.compiler.generator

import quartz.compiler.generator.program.visit
import quartz.compiler.generator.program.visitPrototype
import quartz.compiler.generator.program.visitTypedef
import quartz.compiler.syntax.tree.ProgramNode

/**
 * Created by Aedan Smith.
 */

fun ProgramNode.visit(string: StringBuilder) {
    structDeclarations.forEach { it.visitPrototype(string) }
    if (!structDeclarations.isEmpty()) string.appendln()
    fnDeclarations.sortedBy { it.args.size }.forEach { it.visitTypedef(string) }
    if (!fnDeclarations.isEmpty()) string.appendln()
    fnDeclarations.forEach { it.visitPrototype(string) }
    inlineCNodes.forEach { it.visit(string) }
    if (!structDeclarations.isEmpty() || !inlineCNodes.isEmpty()) string.appendln()
    structDeclarations.forEach { it.visit(string) }
    fnDeclarations.forEach {
        it.visit(string)
        string.appendln()
    }
}
