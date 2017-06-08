package quartz.compiler.semantics

import quartz.compiler.semantics.analyzers.expression.*
import quartz.compiler.semantics.analyzers.verifyType
import quartz.compiler.semantics.tables.FunctionDeclarationSymbolTable
import quartz.compiler.semantics.tables.SymbolTable
import quartz.compiler.semantics.types.*
import quartz.compiler.semantics.util.visitors.blockVisitor
import quartz.compiler.semantics.util.visitors.functionDeclarationVisitor
import quartz.compiler.semantics.visitors.ExternFunctionDeclarationVisitor
import quartz.compiler.semantics.visitors.FunctionDeclarationVisitor
import quartz.compiler.semantics.visitors.TypeVisitor
import quartz.compiler.tree.declarations.ExternFunctionDeclaration
import quartz.compiler.tree.declarations.FunctionDeclaration
import quartz.compiler.tree.declarations.InlineC
import quartz.compiler.tree.expression.Block
import quartz.compiler.tree.expression.Expression
import quartz.compiler.tree.expression.expressions.*
import quartz.compiler.tree.util.Type
import quartz.compiler.util.partial

/**
 * Created by Aedan Smith.
 */

data class Analyzer(
        val analyzeExpressionObserver: Analyzer.(SymbolTable, Type?, Expression) -> Expression,
        val analyzeTypeObserver: Analyzer.(SymbolTable, Type) -> Type
) {
    constructor() : this(
            { _, _, e -> e },
            { _, type -> type }
    )

    fun analyzeExternFunctionDeclaration(
            table: SymbolTable,
            declaration: ExternFunctionDeclaration
    ): ExternFunctionDeclaration {
        return declaration
                .let { ExternFunctionDeclarationVisitor.visitTypes(this::analyzeType.partial(table), it) }
    }

    fun analyzeFunctionDeclaration(
            table: SymbolTable,
            declaration: FunctionDeclaration
    ): FunctionDeclaration {
        val symbolTable = FunctionDeclarationSymbolTable(table, declaration)
        return declaration
                .let { FunctionDeclarationVisitor.visitTypes(this::analyzeType.partial(symbolTable), it) }
                .let(this::analyzeBlock.partial(symbolTable).functionDeclarationVisitor())
    }

    fun analyzeBlock(
            table: SymbolTable,
            block: Block
    ): Block {
        return block
                .let(this::analyzeExpression.blockVisitor(table))
    }

    fun analyzeExpression(
            table: SymbolTable,
            expectedType: Type?,
            expression: Expression
    ): Expression {
        val typeVisitor = this::analyzeType.partial(table)
        val expressionAnalyzer = this::analyzeExpression.partial(table)
        return expression.let {
            when (it) {
                is InlineC -> it
                is NumberLiteral -> it
                is StringLiteral -> it
                is Identifier -> it
                        .let { IdentifierAnalyzer.analyzeType(this::analyzeType, table, it) }
                is Sizeof -> it
                        .let { SizeofAnalyzer.visitSizeofType(typeVisitor, it) }
                is Cast -> it
                        .let { CastAnalyzer.visitType(typeVisitor, it) }
                        .let { CastAnalyzer.analyzeExpression(expressionAnalyzer, it, expectedType) }
                is ReturnExpression -> it
                        .let { ReturnExpressionAnalyzer.analyzeExpression(expressionAnalyzer, it) }
                is UnaryOperator -> it
                        .let { UnaryOperatorAnalyzer.analyzeExpression(expressionAnalyzer, it, expectedType) }
                        .let(UnaryOperatorAnalyzer::inferTypeFromExpression)
                is BinaryOperator -> it
                        .let { BinaryOperatorAnalyzer.analyzeExpr1(expressionAnalyzer, it, expectedType) }
                        .let { BinaryOperatorAnalyzer.analyzeExpr2(expressionAnalyzer, it, expectedType) }
                        .let(BinaryOperatorAnalyzer::inferTypeFromExpr1)
                        .let(BinaryOperatorAnalyzer::inferTypeFromExpr2)
                is Assignment -> it
                        .let { AssignmentAnalyzer.analyzeLValue(expressionAnalyzer, it) }
                        .let { AssignmentAnalyzer.analyzeExpression(expressionAnalyzer, it, expectedType) }
                        .let(AssignmentAnalyzer::inferTypeFromLValue)
                        .let(AssignmentAnalyzer::inferTypeFromExpression)
                is FunctionCall -> it
                        .let { FunctionCallAnalyzer.analyzeExpression(expressionAnalyzer, it) }
                        .let { FunctionCallAnalyzer.analyzeArguments(expressionAnalyzer, it) }
                is IfExpression -> it
                        .let { IfExpressionAnalyzer.analyzeCondition(expressionAnalyzer, it) }
                        .let { IfExpressionAnalyzer.analyzeIfTrue(expressionAnalyzer, it, expectedType) }
                        .let { IfExpressionAnalyzer.analyzeIfFalse(expressionAnalyzer, it, expectedType) }
                        .let(IfExpressionAnalyzer::inferTypeFromIfTrue)
                        .let(IfExpressionAnalyzer::inferTypeFromIfFalse)
                is VariableDeclaration -> it
                        .let { VariableDeclarationAnalyzer.visitVariableType(typeVisitor, it) }
                        .let { VariableDeclarationAnalyzer.analyzeExpression(expressionAnalyzer, it) }
                        .let(VariableDeclarationAnalyzer::inferVariableTypeFromExpression)
                        .let { VariableDeclarationAnalyzer.visitVariableType(typeVisitor, it) }
                is BlockExpression -> it
                        .let { BlockExpressionAnalyzer.analyzeExpressions(expressionAnalyzer, it) }
                else -> throw Exception("Expected expression, found $it")
            }
        }
                .let { verifyType(expectedType, it) }
                .let { analyzeExpressionObserver(table, expectedType, it) }
    }

    fun analyzeType(
            table: SymbolTable,
            type: Type
    ): Type {
        val typeAnalyzer = this::analyzeType.partial(table)
        return type
                .let {
                    when (it) {
                        is VoidType -> it
                        is NumberType -> it
                        is InlineCType -> it
                        is ConstType -> TypeVisitor.visitConstType(typeAnalyzer, it)
                        is PointerType -> TypeVisitor.visitPointerType(typeAnalyzer, it)
                        is FunctionType -> TypeVisitor.visitFunctionType(typeAnalyzer, it)
                        is NamedType -> TypeVisitor.visitNamedType(table::getType, it)
                        else -> throw Exception("Expected type, found $it")
                    }
                }
                .let { analyzeTypeObserver(table, it) }
    }

    operator fun plus(observer: Analyzer.(SymbolTable, Type?, Expression) -> Expression): Analyzer {
        return copy(analyzeExpressionObserver = {
            table, type, expr -> this@Analyzer.analyzeExpressionObserver(this@Analyzer, table, type, expr)
                .let { observer(table, type, it) }
        })
    }
}
