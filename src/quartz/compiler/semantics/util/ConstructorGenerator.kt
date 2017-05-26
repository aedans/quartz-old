package quartz.compiler.semantics.util

import quartz.compiler.errors.errorScope
import quartz.compiler.semantics.types.type
import quartz.compiler.tree.function.Expression
import quartz.compiler.tree.function.FunctionDeclaration
import quartz.compiler.tree.function.expression.BlockExpression
import quartz.compiler.tree.function.expression.Identifier
import quartz.compiler.tree.function.expression.ReturnExpression
import quartz.compiler.tree.function.expression.VariableDeclaration
import quartz.compiler.tree.misc.InlineC
import quartz.compiler.tree.struct.StructDeclaration
import quartz.compiler.tree.util.Function

/**
 * Created by Aedan Smith.
 */

fun StructDeclaration.defaultConstructor(): FunctionDeclaration {
    return errorScope({ "$name default constructor" }) {
        val argsNames = members.map { it.key }
        val argTypes = members.map { it.value.type }
        val newType = type()

        val declarationNode = VariableDeclaration("instance", null, newType)
        val assignmentNodes = members.map { InlineC("instance.${it.key} = ${it.value.name}") }
        val returnNode = ReturnExpression(Identifier("instance", emptyList(), newType))

        val expressions = mutableListOf<Expression>()
        expressions.add(declarationNode)
        expressions.addAll(assignmentNodes)
        expressions.add(returnNode)

        FunctionDeclaration(name, argsNames, generics, Function(argTypes, newType, false), BlockExpression(expressions))
    }
}
