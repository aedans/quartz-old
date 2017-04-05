package quartz.compiler.semantics

import quartz.compiler.tree.Program
import quartz.compiler.tree.function.FnDeclaration
import quartz.compiler.tree.function.Statement
import quartz.compiler.tree.function.expression.Identifier
import quartz.compiler.tree.function.statement.ReturnStatement
import quartz.compiler.tree.function.statement.VariableDeclaration
import quartz.compiler.tree.misc.InlineC
import quartz.compiler.tree.struct.StructDeclaration
import quartz.compiler.util.Function

/**
 * Created by Aedan Smith.
 */

fun Program.generateConstructors(): Program {
    return Program(
            fnDeclarations + structDeclarations.filterValues { !it.external }.mapValues { it.value.defaultConstructor() },
            externFunctionDeclarations,
            structDeclarations,
            typealiasDeclarations,
            inlineCNodes
    )
}

private fun StructDeclaration.defaultConstructor(): FnDeclaration {
    val argsNames = members.map { it.key }
    val argTypes = members.map { it.value.type }
    val newType = type.withTemplates(templates)

    val declarationNode = VariableDeclaration("instance", null, newType, true)
    val assignmentNodes = members.map { InlineC("instance.${it.key} = ${it.value.name}") }
    val returnNode = ReturnStatement(Identifier("instance", newType))

    val statements = mutableListOf<Statement>()
    statements.add(declarationNode)
    statements.addAll(assignmentNodes)
    statements.add(returnNode)

    return FnDeclaration(name, argsNames, Function(argTypes, templates, newType, false), statements)
}
