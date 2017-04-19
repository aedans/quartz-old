package quartz.compiler.semantics

import quartz.compiler.exceptions.QuartzException
import quartz.compiler.tree.Program
import quartz.compiler.tree.function.FunctionDeclaration
import quartz.compiler.tree.function.Statement
import quartz.compiler.tree.function.expression.Assignment
import quartz.compiler.tree.function.expression.Identifier
import quartz.compiler.tree.function.expression.PostfixUnaryOperator
import quartz.compiler.tree.function.expression.PrefixUnaryOperator
import quartz.compiler.tree.function.statement.*
import quartz.compiler.tree.misc.InlineC

/**
 * Created by Aedan Smith.
 */

fun Program.generateDestructors(): Program {
    return this.mapFunctionDeclarations { it.generateDestructors(destructorDeclarations) }
}

private fun FunctionDeclaration.generateDestructors(destructorDeclarations: Map<String, FunctionDeclaration>): FunctionDeclaration {
    return FunctionDeclaration(name, argNames, function, block.generateDestructors(destructorDeclarations))
}

private fun Block.generateDestructors(destructorDeclarations: Map<String, FunctionDeclaration>): Block {
    val variables = statementList.filterIsInstance(VariableDeclaration::class.java).filter { it.type.asStruct() != null }
    val newStatements = statementList.map { it.generateDestructors(destructorDeclarations) }.toMutableList()
    variables.forEach { it.generateDestructor(newStatements, destructorDeclarations) }
    return Block(newStatements)
}

private fun Statement.generateDestructors(destructorDeclarations: Map<String, FunctionDeclaration>): Statement {
    return when (this) {
        is InlineC -> this
        is PrefixUnaryOperator -> this
        is PostfixUnaryOperator -> this
        is VariableDeclaration -> this
        is Assignment -> this
        is ReturnStatement -> this
        is FunctionCall -> this
        is Delete -> this
        is IfStatement -> generateDestructors(destructorDeclarations)
        is WhileLoop -> generateDestructors(destructorDeclarations)
        is TypeSwitch -> generateDestructors(destructorDeclarations)
        else -> throw QuartzException("Unrecognized node $this")
    }
}

private fun IfStatement.generateDestructors(destructorDeclarations: Map<String, FunctionDeclaration>): IfStatement {
    return IfStatement(
            test,
            trueBlock.generateDestructors(destructorDeclarations),
            falseBlock.generateDestructors(destructorDeclarations)
    )
}

private fun WhileLoop.generateDestructors(destructorDeclarations: Map<String, FunctionDeclaration>): WhileLoop {
    return WhileLoop(test, block.generateDestructors(destructorDeclarations))
}

private fun TypeSwitch.generateDestructors(destructorDeclarations: Map<String, FunctionDeclaration>): TypeSwitch {
    return TypeSwitch(
            identifier,
            branches.mapValues { it.value.generateDestructors(destructorDeclarations) },
            elseBranch.generateDestructors(destructorDeclarations)
    )
}

private fun VariableDeclaration.generateDestructor(statements: MutableList<Statement>, destructorDeclarations: Map<String, FunctionDeclaration>) {
    val destructor = getDestructor(destructorDeclarations) ?: return
    val lastUse = statements.indexOfLast {
        it.getExpressions().any { it is Identifier && it.name == this.name }
    }.let { if (it == -1) statements.indexOf(this) else it }
    if (statements[lastUse] !is ReturnStatement)
        statements.add(lastUse + 1, destructor)
}

private fun VariableDeclaration.getDestructor(destructorDeclarations: Map<String, FunctionDeclaration>): Statement? {
    val destructor = destructorDeclarations[type?.string]
    return if (destructor == null) InlineC("/* ${type?.descriptiveString} does not have a destructor */") else
        Delete(Identifier(name, type))
}
