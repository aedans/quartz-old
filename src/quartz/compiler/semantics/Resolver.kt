package quartz.compiler.semantics

import quartz.compiler.errors.QuartzException
import quartz.compiler.semantics.contexts.DeclarationContext
import quartz.compiler.semantics.contexts.ProgramContext
import quartz.compiler.semantics.types.*
import quartz.compiler.semantics.util.without
import quartz.compiler.tree.Declaration
import quartz.compiler.tree.Program
import quartz.compiler.tree.declarations.ExternFunctionDeclaration
import quartz.compiler.tree.declarations.FunctionDeclaration
import quartz.compiler.tree.declarations.InlineC
import quartz.compiler.tree.declarations.TypealiasDeclaration
import quartz.compiler.tree.expression.Block
import quartz.compiler.tree.expression.Expression
import quartz.compiler.tree.expression.expressions.*
import quartz.compiler.tree.util.Function
import quartz.compiler.tree.util.Type
import quartz.compiler.util.prepend

/**
 * Created by Aedan Smith.
 */

private val noDeclarations = emptyList<Declaration>()

fun Program.resolve(): Program {
    return ProgramContext(this).resolve()
}

private fun ProgramContext.resolve(): List<Declaration> {
    return (functionDeclarations["main"] as? Declaration)?.resolve(this)?.prepend(inlineC)
            ?: throw QuartzException("Could not find function main")
}

private fun Declaration.resolve(declarationContext: DeclarationContext): List<Declaration> {
    return when (this) {
        is FunctionDeclaration -> resolve(declarationContext)
        is ExternFunctionDeclaration -> resolve(declarationContext)
        is TypealiasDeclaration -> resolve(declarationContext)
        else -> throw Exception("Expected declaration, found $this")
    } + this
}

private fun ExternFunctionDeclaration.resolve(declarationContext: DeclarationContext): List<Declaration> {
    return function.resolve(declarationContext)
}

private fun TypealiasDeclaration.resolve(declarationContext: DeclarationContext): List<Declaration> {
    return aliasedType.resolve(declarationContext)
}

private fun FunctionDeclaration.resolve(declarationContext: DeclarationContext): List<Declaration> {
    val context = declarationContext.without(name)
    return block.resolve(context) + function.resolve(declarationContext)
}

private fun Block.resolve(declarationContext: DeclarationContext): List<Declaration> {
    return expressionList.map { it.resolve(declarationContext) }.flatten()
}

private fun Expression.resolve(declarationContext: DeclarationContext): List<Declaration> {
    return when (this) {
        is InlineC -> noDeclarations
        is NumberLiteral -> noDeclarations
        is StringLiteral -> noDeclarations
        is Identifier -> resolve(declarationContext)
        is Sizeof -> type.resolve(declarationContext)
        is Cast -> expression.resolve(declarationContext) + type.resolve(declarationContext)
        is ReturnExpression -> expression.resolve(declarationContext)
        is UnaryOperator -> expression.resolve(declarationContext)
        is BinaryOperator -> expr1.resolve(declarationContext) + expr2.resolve(declarationContext)
        is Assignment -> lvalue.resolve(declarationContext) + expression.resolve(declarationContext)
        is FunctionCall -> expression.resolve(declarationContext) + (args.map { it.resolve(declarationContext) }.flatten())
        is IfExpression -> condition.resolve(declarationContext) +
                (ifTrue as Expression).resolve(declarationContext) +
                (ifFalse as Expression).resolve(declarationContext)
        is VariableDeclaration -> (expression?.resolve(declarationContext) ?: noDeclarations) +
                (variableType?.resolve(declarationContext) ?: noDeclarations)
        is BlockExpression -> expressionList.map { it.resolve(declarationContext) }.flatten()
        else -> throw Exception("Expected expression, found $this")
    }
}

private fun Identifier.resolve(declarationContext: DeclarationContext): List<Declaration> {
    val declaration = declarationContext.getDeclaration(name)
    return declaration?.resolve(declarationContext) ?: noDeclarations
}

private fun Type.resolve(declarationContext: DeclarationContext): List<Declaration> {
    return when (this) {
        is VoidType -> noDeclarations
        is NumberType -> noDeclarations
        is InlineCType -> noDeclarations
        is ConstType -> type.resolve(declarationContext)
        is PointerType -> type.resolve(declarationContext)
        is FunctionType -> function.resolve(declarationContext)
        is NamedType -> resolve(declarationContext)
        else -> throw Exception("Expected type, found $this")
    }
}

private fun NamedType.resolve(declarationContext: DeclarationContext): List<Declaration> {
    val declaration = declarationContext.getDeclaration(string)
    return declaration?.resolve(declarationContext) ?: noDeclarations
}

private fun Function.resolve(declarationContext: DeclarationContext): List<Declaration> {
    return (returnType?.resolve(declarationContext) ?: noDeclarations) +
            (args?.map { it?.resolve(declarationContext) ?: noDeclarations }?.flatten() ?: noDeclarations)
}
