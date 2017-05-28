package quartz.compiler.semantics

import quartz.compiler.errors.QuartzException
import quartz.compiler.semantics.consumers.GlobalDeclarationConsumer
import quartz.compiler.semantics.symbols.SymbolTable
import quartz.compiler.semantics.symbols.TypeTable
import quartz.compiler.semantics.types.*
import quartz.compiler.semantics.util.visitors.blockVisitor
import quartz.compiler.semantics.util.visitors.functionDeclarationVisitor
import quartz.compiler.semantics.visitors.*
import quartz.compiler.semantics.visitors.expression.*
import quartz.compiler.tree.Program
import quartz.compiler.tree.function.Block
import quartz.compiler.tree.function.Expression
import quartz.compiler.tree.function.FunctionDeclaration
import quartz.compiler.tree.function.expression.*
import quartz.compiler.tree.misc.ExternFunctionDeclaration
import quartz.compiler.tree.misc.InlineC
import quartz.compiler.tree.util.Type
import quartz.compiler.util.partial

/**
 * Created by Aedan Smith.
 */

fun Program.analyze(): Program {
    val symbolTable = ProgramAnalyzer.symbolTable(this)
    var newProgram = Program()
    analyzeProgram(
            object : GlobalDeclarationConsumer {
                override fun eat(externFunctionDeclaration: ExternFunctionDeclaration) {
                    if (!newProgram.externFunctionDeclarations.contains(externFunctionDeclaration.name)) {
                        newProgram += externFunctionDeclaration
                        val new = analyzeExternFunctionDeclaration(symbolTable, externFunctionDeclaration)
                        newProgram += new
                    }
                }

                override fun eat(functionDeclaration: FunctionDeclaration) {
                    if (!newProgram.functionDeclarations.contains(functionDeclaration.name)) {
                        newProgram += functionDeclaration
                        val new = analyzeFunctionDeclaration(this, symbolTable, functionDeclaration)
                        newProgram += new
                    }
                }
            },
            this
    )
    inlineCDeclarations.forEach { newProgram += it }
    return newProgram
}

private fun analyzeProgram(
        globalDeclarationConsumer: GlobalDeclarationConsumer,
        program: Program
) {
    return (program.functionDeclarations["main"] ?: throw QuartzException("Could not find function main"))
            .let { globalDeclarationConsumer.eat(it) }
}

private fun analyzeExternFunctionDeclaration(
        symbolTable: SymbolTable,
        declaration: ExternFunctionDeclaration
): ExternFunctionDeclaration {
    return declaration
            .let { ExternFunctionDeclarationAnalyzer.analyzeTypes(::analyzeType.partial(symbolTable), it) }
}

private fun analyzeFunctionDeclaration(
        globalDeclarationConsumer: GlobalDeclarationConsumer,
        symbolTable: SymbolTable,
        declaration: FunctionDeclaration
): FunctionDeclaration {
    val localSymbolTable = FunctionDeclarationAnalyzer.localSymbolTable(symbolTable, declaration)
    return declaration
            .let { FunctionDeclarationAnalyzer.visitTypes(::analyzeType.partial(localSymbolTable), it) }
            .let(::analyzeBlock.partial(globalDeclarationConsumer).partial(localSymbolTable).functionDeclarationVisitor())
//            .let { FunctionDeclarationAnalyzer.resolveGenerics(genericArguments, it) }
}

private fun analyzeBlock(
        globalDeclarationConsumer: GlobalDeclarationConsumer,
        symbolTable: SymbolTable,
        block: Block
): Block {
    return block
            .let(::analyzeExpression.partial(globalDeclarationConsumer).blockVisitor(symbolTable))
}

private fun analyzeExpression(
        globalDeclarationConsumer: GlobalDeclarationConsumer,
        symbolTable: SymbolTable,
        expectedType: Type?,
        expression: Expression
): Expression {
    val expressionAnalyzer = ::analyzeExpression.partial(globalDeclarationConsumer).partial(symbolTable)
    val typeAnalyzer = ::analyzeType.partial(symbolTable)
    return expression.let {
        when (it) {
            is InlineC -> it
            is NumberLiteral -> it
            is StringLiteral -> it
            is Identifier -> {
                it
                        .let { IdentifierAnalyzer.analyzeType(symbolTable, it) }
                        .also {
                            IdentifierAnalyzer.visitGlobalDeclaration(
                                    globalDeclarationConsumer,
                                    symbolTable::getGlobalDeclaration,
                                    it
                            )
                        }
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
                        .let { VariableDeclarationAnalyzer.analyzeExpression(expressionAnalyzer, it) }
                        .let(VariableDeclarationAnalyzer::inferVariableTypeFromExpression)
                        .let { VariableDeclarationAnalyzer.visitVariableType(typeAnalyzer, it) }
            }
            is BlockExpression -> {
                it
                        .let { BlockExpressionAnalyzer.analyzeExpressions(expressionAnalyzer, it) }
            }
            is Lambda -> {
                it
                        .let { LambdaAnalyzer.inferFunctionType(it, expectedType) }
                        .let(LambdaAnalyzer::inferFunctionArgs)
                        .let(LambdaAnalyzer::inferArgumentNames)
                        .let {
                            LambdaAnalyzer.uninline(
                                    { symbolTable.getGlobalDeclaration(it) != null },
                                    it,
                                    globalDeclarationConsumer
                            )
                        }
                        .let { expressionAnalyzer(expectedType, it) }
            }
            else -> throw Exception("Expected expression, found $it")
        }
    }
            .let { ExpressionAnalyzer.verifyType(expectedType, it) }
}

private fun analyzeType(
        typeTable: TypeTable,
        type: Type
): Type {
    return type.let {
        when (it) {
            is VoidType -> it
            is NumberType -> it
            is InlineCType -> it
            is ConstType -> TypeAnalyzer.analyzeConstType(::analyzeType.partial(typeTable), it)
            is PointerType -> TypeAnalyzer.analyzePointerType(::analyzeType.partial(typeTable), it)
            is FunctionType -> TypeAnalyzer.analyzeFunctionType(::analyzeType.partial(typeTable), it)
            is NamedType -> TypeAnalyzer.analyzeNamedType(typeTable::getType, it)
            else -> throw Exception("Expected type, found $it")
        }
    }
}
