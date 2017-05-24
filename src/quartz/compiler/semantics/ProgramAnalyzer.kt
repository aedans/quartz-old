package quartz.compiler.semantics

import quartz.compiler.semantics.contexts.*
import quartz.compiler.semantics.types.*
import quartz.compiler.semantics.util.contextVisitor
import quartz.compiler.semantics.util.identityVisitor
import quartz.compiler.semantics.util.visitors.blockVisitor
import quartz.compiler.semantics.util.visitors.functionDeclarationVisitor
import quartz.compiler.semantics.util.visitors.programVisitor
import quartz.compiler.semantics.visitors.*
import quartz.compiler.semantics.visitors.expression.*
import quartz.compiler.tree.Program
import quartz.compiler.tree.function.expression.*
import quartz.compiler.tree.misc.InlineC
import quartz.compiler.util.curry

/**
 * Created by Aedan Smith.
 */

fun Program.analyze(): Program {
    return analyzeProgram(ProgramContext(Program(), this, 0)).program
}

private val programAnalyzer = ::analyzeFunctionDeclaration.programVisitor()
private fun analyzeProgram(context: ProgramContext): ProgramContext {
    return context
            .let(ProgramAnalyzer::generateDefaultConstructors)
            .let(programAnalyzer)
            .let(ProgramAnalyzer::migrateInlineC)
}

private val structDeclarationTypeAnalyzer = StructDeclarationAnalyzer::analyzeTypes.curry(::analyzeType)
private fun analyzeStructDeclaration(context: StructDeclarationContext): StructDeclarationContext {
    return context
            .let(structDeclarationTypeAnalyzer)
            .let(StructDeclarationAnalyzer::resolveGenerics)
            .let(StructDeclarationAnalyzer::addToProgram)
}

private val analyzeExternFunctionDeclarationTypes = ExternFunctionDeclarationAnalyzer::analyzeTypes.curry(::analyzeType)
private fun analyzeExternFunctionDeclaration(context: ExternFunctionDeclarationContext): ExternFunctionDeclarationContext {
    return context
            .let(analyzeExternFunctionDeclarationTypes)
            .let(ExternFunctionDeclarationAnalyzer::addToProgram)
}

private val analyzeFunctionDeclarationTypes = FunctionDeclarationAnalyzer::analyzeTypes.curry(::analyzeType)
private val functionDeclarationAnalyzer = ::analyzeBlock.functionDeclarationVisitor()
private fun analyzeFunctionDeclaration(context: FunctionDeclarationContext): FunctionDeclarationContext {
    return context
            .let(analyzeFunctionDeclarationTypes)
            .let(functionDeclarationAnalyzer)
            .let(FunctionDeclarationAnalyzer::resolveGenerics)
            .let(FunctionDeclarationAnalyzer::addToProgram)
}

private val blockAnalyzer = ::analyzeExpression.blockVisitor()
private fun analyzeBlock(context: BlockContext): BlockContext {
    return context
            .let(blockAnalyzer)
}

private val analyzeExpressionExpectedType = ExpressionAnalyzer::analyzeExpectedType.curry(::analyzeType)
private fun analyzeExpression(context: ExpressionContext): ExpressionContext {
    return context
            .let(analyzeExpressionExpectedType)
            .let(expressionAnalyzer)
            .let(ExpressionAnalyzer::verifyType)
}

private val expressionAnalyzer = contextVisitor(
        InlineC::class to identityVisitor(),
        NumberLiteral::class to identityVisitor(),
        StringLiteral::class to identityVisitor(),
        Identifier::class to ::analyzeIdentifier,
        Sizeof::class to ::analyzeSizeof,
        Cast::class to ::analyzeCast,
        ReturnExpression::class to ::analyzeReturnExpression,
        UnaryOperator::class to ::analyzeUnaryOperator,
        BinaryOperator::class to ::analyzeBinaryOperator,
        Assignment::class to ::analyzeAssignment,
        FunctionCall::class to ::analyzeFunctionCall,
        MemberAccess::class to ::analyzeMemberAccess,
        IfExpression::class to ::analyzeIfExpression,
        WhileExpression::class to ::analyzeWhileExpression,
        VariableDeclaration::class to ::analyzeVariableDeclaration,
        BlockExpression::class to ::analyzeBlockExpression,
        Lambda::class to ::analyzeLambda
)

private val analyzeIdentifierFunctionDeclaration =
        IdentifierAnalyzer::analyzeFunctionDeclaration.curry(::analyzeFunctionDeclaration)
private val analyzeIdentifierExternFunctionDeclaration =
        IdentifierAnalyzer::analyzeExternFunctionDeclaration.curry(::analyzeExternFunctionDeclaration)
private fun analyzeIdentifier(context: ExpressionContext): ExpressionContext {
    return context
            .let(analyzeIdentifierFunctionDeclaration)
            .let(analyzeIdentifierExternFunctionDeclaration)
            .let(IdentifierAnalyzer::analyzeType)
}

private val analyzeSizeofSizeType = SizeofAnalyzer::analyzeSizeType.curry(::analyzeType)
private fun analyzeSizeof(context: ExpressionContext): ExpressionContext {
    return context
            .let(analyzeSizeofSizeType)
}

private val analyzeCastType = CastAnalyzer::analyzeType.curry(::analyzeType)
private val analyzeCastExpression = CastAnalyzer::analyzeExpression.curry(::analyzeExpression)
private fun analyzeCast(context: ExpressionContext): ExpressionContext {
    return context
            .let(analyzeCastType)
            .let(analyzeCastExpression)
}

private val analyzeReturnExpressionExpression = ReturnExpressionAnalyzer::analyzeExpression.curry(::analyzeExpression)
private fun analyzeReturnExpression(context: ExpressionContext): ExpressionContext {
    return context
            .let(analyzeReturnExpressionExpression)
            .let(ReturnExpressionAnalyzer::verifyReturnType)
}

private val analyzeUnaryOperatorExpression = UnaryOperatorAnalyzer::analyzeExpression.curry(::analyzeExpression)
private fun analyzeUnaryOperator(context: ExpressionContext): ExpressionContext {
    return context
            .let(analyzeUnaryOperatorExpression)
            .let(UnaryOperatorAnalyzer::inferTypeFromExpression)
}

private val analyzeBinaryOperatorExpr1 = BinaryOperatorAnalyzer::analyzeExpr1.curry(::analyzeExpression)
private val analyzeBinaryOperatorExpr2 = BinaryOperatorAnalyzer::analyzeExpr2.curry(::analyzeExpression)
private fun analyzeBinaryOperator(context: ExpressionContext): ExpressionContext {
    return context
            .let(analyzeBinaryOperatorExpr1)
            .let(analyzeBinaryOperatorExpr2)
            .let(BinaryOperatorAnalyzer::inferTypeFromExpr1)
            .let(BinaryOperatorAnalyzer::inferTypeFromExpr2)
}

private val analyzeAssignmentLValue = AssignmentAnalyzer::analyzeLValue.curry(::analyzeExpression)
private val analyzeAssignmentExpression = AssignmentAnalyzer::analyzeExpression.curry(::analyzeExpression)
private fun analyzeAssignment(context: ExpressionContext): ExpressionContext {
    return context
            .let(analyzeAssignmentLValue)
            .let(analyzeAssignmentExpression)
            .let(AssignmentAnalyzer::inferTypeFromLValue)
            .let(AssignmentAnalyzer::inferTypeFromExpression)
}

private val analyzeFunctionCallExpression = FunctionCallAnalyzer::analyzeExpression.curry(::analyzeExpression)
private val analyzeFunctionCallArguments = FunctionCallAnalyzer::analyzeArguments.curry(::analyzeExpression)
private fun analyzeFunctionCall(context: ExpressionContext): ExpressionContext {
    return context
            .let(analyzeFunctionCallExpression)
            .let(analyzeFunctionCallArguments)
}

private val analyzeMemberAccessExpression = MemberAccessAnalyzer::analyzeExpression.curry(::analyzeExpression)
private val analyzeMemberAccessExpressionType = MemberAccessAnalyzer::analyzeExpressionType.curry(::analyzeType)
private fun analyzeMemberAccess(context: ExpressionContext): ExpressionContext {
    return context
            .let(analyzeMemberAccessExpression)
            .let(analyzeMemberAccessExpressionType)
            .let(MemberAccessAnalyzer::analyzeMember)
}

private val analyzeIfExpressionCondition = IfExpressionAnalyzer::analyzeCondition.curry(::analyzeExpression)
private val analyzeIfExpressionIfTrue = IfExpressionAnalyzer::analyzeIfTrue.curry(::analyzeBlockExpression)
private val analyzeIfExpressionIfFalse = IfExpressionAnalyzer::analyzeIfFalse.curry(::analyzeBlockExpression)
private fun analyzeIfExpression(context: ExpressionContext): ExpressionContext {
    return context
            .let(analyzeIfExpressionCondition)
            .let(analyzeIfExpressionIfTrue)
            .let(analyzeIfExpressionIfFalse)
            .let(IfExpressionAnalyzer::inferTypeFromIfTrue)
            .let(IfExpressionAnalyzer::inferTypeFromIfFalse)
}

private val analyzeWhileExpressionCondition = WhileExpressionAnalyzer::analyzeCondition.curry(::analyzeExpression)
private val analyzeWhileExpressionBlock = WhileExpressionAnalyzer::analyzeBlock.curry(::analyzeBlockExpression)
private fun analyzeWhileExpression(context: ExpressionContext): ExpressionContext {
    return context
            .let(analyzeWhileExpressionCondition)
            .let(analyzeWhileExpressionBlock)
}

private val analyzeVariableDeclarationExpression = VariableDeclarationAnalyzer::analyzeExpression.curry(::analyzeExpression)
private val analyzeVariableDeclarationType = VariableDeclarationAnalyzer::analyzeVariableType.curry(::analyzeType)
private fun analyzeVariableDeclaration(context: ExpressionContext): ExpressionContext {
    return context
            .let(analyzeVariableDeclarationExpression)
            .let(analyzeVariableDeclarationType)
            .let(VariableDeclarationAnalyzer::addToSymbolTable)
}

private val analyzeBlockExpressionExpressions = BlockExpressionAnalyzer::analyzeExpressions.curry(::analyzeExpression)
private fun analyzeBlockExpression(context: ExpressionContext): ExpressionContext {
    return context
            .let(analyzeBlockExpressionExpressions)
}

private fun analyzeLambda(context: ExpressionContext): ExpressionContext {
    return context
            .let(LambdaAnalyzer::inferFunctionType)
            .let(LambdaAnalyzer::inferFunctionArgs)
            .let(LambdaAnalyzer::inferArgumentNames)
            .let(LambdaAnalyzer::uninline)
            .let(::analyzeIdentifier)
}

private fun analyzeType(context: TypeContext): TypeContext {
    return context
            .let(typeAnalyzer)
}

private val typeAnalyzer = contextVisitor(
        VoidType::class to identityVisitor(),
        NumberType::class to identityVisitor(),
        InlineCType::class to identityVisitor(),
        ConstType::class to TypeAnalyzer::analyzeConstType.curry(::analyzeType),
        PointerType::class to TypeAnalyzer::analyzePointerType.curry(::analyzeType),
        FunctionType::class to TypeAnalyzer::analyzeFunctionType.curry(::analyzeType),
        StructType::class to TypeAnalyzer::analyzeStructType.curry(::analyzeType).curry(::analyzeStructDeclaration),
        NamedType::class to TypeAnalyzer::analyzeNamedType.curry(::analyzeType)
)
