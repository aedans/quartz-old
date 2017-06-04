package quartz.compiler.semantics

import quartz.compiler.semantics.analyzers.ExpressionAnalyzer
import quartz.compiler.semantics.analyzers.expression.*
import quartz.compiler.semantics.contexts.FunctionDeclarationContext
import quartz.compiler.semantics.contexts.ProgramContext
import quartz.compiler.semantics.contexts.SymbolContext
import quartz.compiler.semantics.contexts.TypeContext
import quartz.compiler.semantics.types.*
import quartz.compiler.semantics.util.visitors.blockVisitor
import quartz.compiler.semantics.util.visitors.functionDeclarationVisitor
import quartz.compiler.semantics.visitors.ExternFunctionDeclarationVisitor
import quartz.compiler.semantics.visitors.FunctionDeclarationVisitor
import quartz.compiler.semantics.visitors.TypeVisitor
import quartz.compiler.tree.Declaration
import quartz.compiler.tree.Program
import quartz.compiler.tree.function.Block
import quartz.compiler.tree.function.Expression
import quartz.compiler.tree.function.FunctionDeclaration
import quartz.compiler.tree.function.expression.*
import quartz.compiler.tree.misc.ExternFunctionDeclaration
import quartz.compiler.tree.misc.InlineC
import quartz.compiler.tree.misc.TypealiasDeclaration
import quartz.compiler.tree.util.Type
import quartz.compiler.util.partial

/**
 * Created by Aedan Smith.
 */

fun Program.analyze(): Program {
    val programContext = ProgramContext(this)
    return map { it.analyze(programContext) }
}

fun Declaration.analyze(symbolContext: SymbolContext): Declaration {
    return when (this) {
        is InlineC -> this
        is TypealiasDeclaration -> this
        is FunctionDeclaration -> analyzeFunctionDeclaration(symbolContext, this)
        is ExternFunctionDeclaration -> analyzeExternFunctionDeclaration(symbolContext, this)
        else -> throw Exception("Expected declaration, found $this")
    }
}

private fun analyzeExternFunctionDeclaration(
        context: SymbolContext,
        declaration: ExternFunctionDeclaration
): ExternFunctionDeclaration {
    return declaration
            .let { ExternFunctionDeclarationVisitor.visitTypes(::analyzeType.partial(context), it) }
}

private fun analyzeFunctionDeclaration(
        symbolContext: SymbolContext,
        declaration: FunctionDeclaration
): FunctionDeclaration {
    val functionDeclarationContext = FunctionDeclarationContext(symbolContext, declaration)
    return declaration
            .let { FunctionDeclarationVisitor.visitTypes(::analyzeType.partial(functionDeclarationContext), it) }
            .let(::analyzeBlock.partial(functionDeclarationContext).functionDeclarationVisitor())
}

private fun analyzeBlock(
        symbolContext: SymbolContext,
        block: Block
): Block {
    return block
            .let(::analyzeExpression.blockVisitor(symbolContext))
}

private fun analyzeExpression(
        symbolContext: SymbolContext,
        expectedType: Type?,
        expression: Expression
): Expression {
    val expressionAnalyzer = ::analyzeExpression.partial(symbolContext)
    val typeAnalyzer = ::analyzeType.partial(symbolContext)
    return expression.let {
        when (it) {
            is InlineC -> it
            is NumberLiteral -> it
            is StringLiteral -> it
            is Identifier -> {
                it
                        .let { IdentifierAnalyzer.analyzeType(::analyzeType, symbolContext, it) }
            }
            is Sizeof -> {
                it
                        .let { SizeofAnalyzer.visitSizeofType(typeAnalyzer, it) }
            }
            is Cast -> {
                it
                        .let { CastAnalyzer.visitType(typeAnalyzer, it) }
                        .let { CastAnalyzer.analyzeExpression(expressionAnalyzer, it, expectedType) }
            }
            is ReturnExpression -> {
                it
                        .let { ReturnExpressionAnalyzer.analyzeExpression(expressionAnalyzer, it) }
            }
            is UnaryOperator -> {
                it
                        .let { UnaryOperatorAnalyzer.analyzeExpression(expressionAnalyzer, it, expectedType) }
                        .let(UnaryOperatorAnalyzer::inferTypeFromExpression)
            }
            is BinaryOperator -> {
                it
                        .let { BinaryOperatorAnalyzer.analyzeExpr1(expressionAnalyzer, it, expectedType) }
                        .let { BinaryOperatorAnalyzer.analyzeExpr2(expressionAnalyzer, it, expectedType) }
                        .let(BinaryOperatorAnalyzer::inferTypeFromExpr1)
                        .let(BinaryOperatorAnalyzer::inferTypeFromExpr2)
            }
            is Assignment -> {
                it
                        .let { AssignmentAnalyzer.analyzeLValue(expressionAnalyzer, it) }
                        .let { AssignmentAnalyzer.analyzeExpression(expressionAnalyzer, it, expectedType) }
                        .let(AssignmentAnalyzer::inferTypeFromLValue)
                        .let(AssignmentAnalyzer::inferTypeFromExpression)
            }
            is FunctionCall -> {
                it
                        .let { FunctionCallAnalyzer.analyzeExpression(expressionAnalyzer, it) }
                        .let { FunctionCallAnalyzer.analyzeArguments(expressionAnalyzer, it) }
            }
            is IfExpression -> {
                it
                        .let { IfExpressionAnalyzer.analyzeCondition(expressionAnalyzer, it) }
                        .let { IfExpressionAnalyzer.analyzeIfTrue(expressionAnalyzer, it, expectedType) }
                        .let { IfExpressionAnalyzer.analyzeIfFalse(expressionAnalyzer, it, expectedType) }
                        .let(IfExpressionAnalyzer::inferTypeFromIfTrue)
                        .let(IfExpressionAnalyzer::inferTypeFromIfFalse)
            }
            is VariableDeclaration -> {
                it
                        .let { VariableDeclarationAnalyzer.visitVariableType(typeAnalyzer, it) }
                        .let { VariableDeclarationAnalyzer.analyzeExpression(expressionAnalyzer, it) }
                        .let(VariableDeclarationAnalyzer::inferVariableTypeFromExpression)
                        .let { VariableDeclarationAnalyzer.visitVariableType(typeAnalyzer, it) }
            }
            is BlockExpression -> {
                it
                        .let { BlockExpressionAnalyzer.analyzeExpressions(expressionAnalyzer, it) }
            }
            else -> throw Exception("Expected expression, found $it")
        }
    }
            .let { ExpressionAnalyzer.verifyType(expectedType, it) }
}

private fun analyzeType(
        typeContext: TypeContext,
        type: Type
): Type {
    return type.let {
        when (it) {
            is VoidType -> it
            is NumberType -> it
            is InlineCType -> it
            is ConstType -> TypeVisitor.visitConstType(::analyzeType.partial(typeContext), it)
            is PointerType -> TypeVisitor.visitPointerType(::analyzeType.partial(typeContext), it)
            is FunctionType -> TypeVisitor.visitFunctionType(::analyzeType.partial(typeContext), it)
            is NamedType -> TypeVisitor.visitNamedType(typeContext::getType, it)
            else -> throw Exception("Expected type, found $it")
        }
    }
}
