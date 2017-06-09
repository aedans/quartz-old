package quartz.compiler.semantics

import quartz.compiler.errors.QuartzException
import quartz.compiler.semantics.analyzers.FunctionDeclarationAnalyzer
import quartz.compiler.semantics.analyzers.expression.*
import quartz.compiler.semantics.analyzers.util.verifyType
import quartz.compiler.semantics.tables.FunctionDeclarationSymbolTable
import quartz.compiler.semantics.tables.ProgramSymbolTable
import quartz.compiler.semantics.tables.SymbolTable
import quartz.compiler.semantics.types.*
import quartz.compiler.semantics.visitors.ExternFunctionDeclarationVisitor
import quartz.compiler.semantics.visitors.FunctionDeclarationVisitor
import quartz.compiler.semantics.visitors.TypeVisitor
import quartz.compiler.tree.Declaration
import quartz.compiler.tree.Program
import quartz.compiler.tree.declarations.ExternFunctionDeclaration
import quartz.compiler.tree.declarations.FunctionDeclaration
import quartz.compiler.tree.declarations.InlineC
import quartz.compiler.tree.expression.Expression
import quartz.compiler.tree.expression.expressions.*
import quartz.compiler.tree.util.Type
import quartz.compiler.util.bind
import quartz.compiler.util.partial

/**
 * Created by Aedan Smith.
 */

private val analyzerImpl = Analyzer(
        Analyzer::analyzeFunctionDeclarationImpl,
        Analyzer::analyzeExternFunctionDeclarationImpl,
        Analyzer::analyzeExpressionImpl,
        Analyzer::analyzeTypeImpl
)

fun Program.analyze(): Program {
    val newProgram = LinkedHashMap<String, Declaration>()
    val programSymbolTable = ProgramSymbolTable(this)

    val analyzer = analyzerImpl +
            { a, b, c -> analyzeIdentifierFunctionDeclaration(newProgram, programSymbolTable, a, b, c) } +
            { a, b, c -> analyzeIdentifierExternFunctionDeclaration(newProgram, programSymbolTable, a, b, c) }

    val main = analyzer.analyzeFunctionDeclaration(analyzer, programSymbolTable, programSymbolTable.functionDeclarations["main"]
            ?: throw QuartzException("Could not find function main"))
    return programSymbolTable.inlineCDeclarations + newProgram.map { it.value } + main
}

private fun Analyzer.analyzeExternFunctionDeclarationImpl(
        table: SymbolTable,
        declaration: ExternFunctionDeclaration
): ExternFunctionDeclaration {
    return declaration
            .let { ExternFunctionDeclarationVisitor.visitTypes(analyzeType.bind(this).partial(table), it) }
}

private fun Analyzer.analyzeFunctionDeclarationImpl(
        table: SymbolTable,
        declaration: FunctionDeclaration
): FunctionDeclaration {
    val symbolTable = FunctionDeclarationSymbolTable(table, declaration)
    return declaration
            .let { FunctionDeclarationVisitor.visitTypes(analyzeType.bind(this).partial(symbolTable), it) }
            .let { FunctionDeclarationAnalyzer.block(analyzeExpression.bind(this).partial(symbolTable), it) }
}

private fun Analyzer.analyzeExpressionImpl(table: SymbolTable, expectedType: Type?, expression: Expression): Expression {
    val typeVisitor = analyzeType.bind(this).partial(table)
    val expressionAnalyzer = analyzeExpression.bind(this).partial(table)
    return expression.let {
        when (it) {
            is InlineC -> it
            is NumberLiteral -> it
            is StringLiteral -> it
            is Identifier -> it
                    .let { IdentifierAnalyzer.analyzeType(analyzeType.bind(this), table, it) }
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
            is Block -> it
                    .let { BlockAnalyzer.analyzeExpressions(analyzeExpression.bind(this), table, expectedType, it) }
            else -> throw Exception("Expected expression, found $it")
        }
    }
            .let { verifyType(expectedType, it) }
}

fun Analyzer.analyzeTypeImpl(
        table: SymbolTable,
        type: Type
): Type {
    val typeAnalyzer = analyzeType.bind(this).partial(table)
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
}

private fun Analyzer.analyzeIdentifierFunctionDeclaration(
        newProgram: LinkedHashMap<String, Declaration>,
        programSymbolTable: ProgramSymbolTable,
        symbolTable: SymbolTable,
        type: Type?,
        expression: Expression
): Expression {
    return if (expression !is Identifier) expression
    else (symbolTable.getDeclaration(expression.name) as? FunctionDeclaration)?.let { declaration ->
        if (!newProgram.contains(declaration.name)) {
            newProgram.put(declaration.name, declaration)
            val newDeclaration = analyzeFunctionDeclaration(programSymbolTable, declaration)
            newProgram.put(newDeclaration.name, newDeclaration)
            Identifier(newDeclaration.name, newDeclaration.type())
        } else expression
    } ?: expression
}

private fun Analyzer.analyzeIdentifierExternFunctionDeclaration(
        newProgram: LinkedHashMap<String, Declaration>,
        programSymbolTable: ProgramSymbolTable,
        symbolTable: SymbolTable,
        type: Type?,
        expression: Expression
): Expression {
    return if (expression !is Identifier) expression
    else (symbolTable.getDeclaration(expression.name) as? ExternFunctionDeclaration)?.let { declaration ->
        if (!newProgram.contains(declaration.name)) {
            newProgram.put(declaration.name, declaration)
            val newDeclaration = analyzeExternFunctionDeclaration(programSymbolTable, declaration)
            newProgram.put(newDeclaration.name, newDeclaration)
            Identifier(newDeclaration.name, newDeclaration.type())
        } else expression
    } ?: expression
}
