package quartz.compiler.semantics

import quartz.compiler.exceptions.QuartzException
import quartz.compiler.semantics.types.FunctionType
import quartz.compiler.syntax.tree.ProgramNode
import quartz.compiler.syntax.tree.function.FnDeclarationNode
import quartz.compiler.syntax.tree.function.expression.IdentifierNode
import quartz.compiler.syntax.tree.function.expression.MemberAccessNode
import quartz.compiler.syntax.tree.function.statement.FnCallNode
import quartz.compiler.util.Function
import quartz.compiler.util.Type

/**
 * Created by Aedan Smith.
 */

fun ProgramNode.resolveTemplates(): ProgramNode {
    val newFnDeclarations = mutableListOf<FnDeclarationNode>()
    newFnDeclarations.addAll(
        fnDeclarations.filter { it.function.templates.isEmpty() }.map {
            it.resolveTemplates(this, newFnDeclarations)
        }
    )
    return ProgramNode(
            newFnDeclarations,
            externFnDeclarations,
            structDeclarations,
            typealiasDeclarations,
            inlineCNodes
    )
}

private fun FnDeclarationNode.resolveTemplates(programNode: ProgramNode, newFnDeclarations: MutableList<FnDeclarationNode>): FnDeclarationNode {
    return this.mapExpressions {
        when (it) {
            is FnCallNode -> it.resolveTemplates(programNode, newFnDeclarations)
            else -> it
        }
    }
}

private fun FnCallNode.resolveTemplates(programNode: ProgramNode, newFnDeclarations: MutableList<FnDeclarationNode>): FnCallNode {
    if (templates.isEmpty())
        return this
    if (expression is MemberAccessNode)
        return resolveDotNotation(programNode.symbolTable).resolveTemplates(programNode, newFnDeclarations)
    if (expression !is IdentifierNode)
        throw QuartzException("Templates are not allowed on variables")

    val newFunction = resolveTemplates(expression.name, templates, programNode, newFnDeclarations)

    return FnCallNode(
            IdentifierNode(newFunction.name, FunctionType(newFunction.function)), emptyList(), expressions, type
    )
}

private fun resolveTemplates(name: String, types: List<Type>, programNode: ProgramNode, newFnDeclarations: MutableList<FnDeclarationNode>): FnDeclarationNode {
    val newFunction = resolveTemplates(
            programNode.fnDeclarations.firstOrNull { it.name == name } ?: throw QuartzException("Unknown function $name"),
            types,
            programNode,
            newFnDeclarations
    )
    newFnDeclarations.add(newFunction)
    return newFunction
}

private fun resolveTemplates(fnDeclaration: FnDeclarationNode, types: List<Type>, programNode: ProgramNode, newFnDeclarations: MutableList<FnDeclarationNode>): FnDeclarationNode {
    val typeMap = fnDeclaration.function.templates.zip(types).toMap()
    var newName = fnDeclaration.name
    typeMap.forEach { newName += "_${it.value.descriptiveString}" }
    return FnDeclarationNode(
            newName,
            fnDeclaration.argNames,
            Function(
                    fnDeclaration.function.args,
                    emptyList(),
                    fnDeclaration.function.returnType,
                    fnDeclaration.function.vararg
            ),
            fnDeclaration.statements
    ).mapTypes { typeMap[it] ?: it }.resolveTemplates(programNode, newFnDeclarations)
}
