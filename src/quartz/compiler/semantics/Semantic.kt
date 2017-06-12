package quartz.compiler.semantics

import quartz.compiler.errors.QuartzException
import quartz.compiler.errors.errorScope
import quartz.compiler.semantics.tables.FunctionDeclarationSymbolTable
import quartz.compiler.semantics.tables.ProgramSymbolTable
import quartz.compiler.semantics.tables.SymbolTable
import quartz.compiler.semantics.types.*
import quartz.compiler.semantics.util.analyze.*
import quartz.compiler.semantics.util.analyze.expressions.*
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
    errorScope({ declaration.name }) {
        return declaration
                .visitTypes(analyzeType.bind(this).partial(table))
    }
}

private fun Analyzer.analyzeFunctionDeclarationImpl(
        table: SymbolTable,
        declaration: FunctionDeclaration
): FunctionDeclaration {
    errorScope({ declaration.name }) {
        val symbolTable = FunctionDeclarationSymbolTable(table, declaration)
        return declaration
                .visitTypes(analyzeType.bind(this).partial(symbolTable))
                .analyzeBlock(analyzeExpression.bind(this).partial(symbolTable))
    }
}

private fun Analyzer.analyzeExpressionImpl(table: SymbolTable, expectedType: Type, expression: Expression): Expression {
    errorScope({ expression.toString() }) {
        val typeVisitor = analyzeType.bind(this).partial(table)
        val expressionAnalyzer = analyzeExpression.bind(this).partial(table)
        return expression.let {
            when (it) {
                is InlineC -> it
                is NumberLiteral -> it
                is StringLiteral -> it
                is Identifier -> it
                        .analyzeType(analyzeType.bind(this), table)
                is Sizeof -> it
                        .visitSizeofType(typeVisitor)
                is Cast -> it
                        .visitType(typeVisitor)
                        .analyzeExpression(expressionAnalyzer, expectedType)
                is UnaryOperator -> it
                        .analyzeExpression(expressionAnalyzer, expectedType)
                        .inferTypeFrom { expression }
                is BinaryOperator -> it
                        .analyzeExpr1(expressionAnalyzer, expectedType)
                        .analyzeExpr2(expressionAnalyzer, expectedType)
                        .inferTypeFrom { expr1 }
                        .inferTypeFrom { expr2 }
                is Assignment -> it
                        .analyzeLValue(expressionAnalyzer)
                        .analyzeExpression(expressionAnalyzer, expectedType)
                        .inferTypeFrom { lvalue }
                        .inferTypeFrom { expression }
                is FunctionCall -> it
                        .analyzeExpression(expressionAnalyzer)
                        .analyzeArguments(expressionAnalyzer)
                is IfExpression -> it
                        .analyzeCondition(expressionAnalyzer)
                        .analyzeIfTrue(expressionAnalyzer, expectedType)
                        .analyzeIfFalse(expressionAnalyzer, expectedType)
                        .inferTypeFrom { ifTrue }
                        .inferTypeFrom { ifFalse }
                is VariableDeclaration -> it
                        .visitVariableType(typeVisitor)
                        .analyzeExpression(expressionAnalyzer)
                        .inferVariableTypeFromExpression()
                        .visitVariableType(typeVisitor)
                is Block -> it
                        .analyzeExpressions(analyzeExpression.bind(this), table, expectedType)
                else -> throw Exception("Expected expression, found $it")
            }
        }
                .verifyType(expectedType)
    }
}

fun Analyzer.analyzeTypeImpl(
        table: SymbolTable,
        type: Type
): Type {
    errorScope({ type.toString() }) {
        val typeAnalyzer = analyzeType.bind(this).partial(table)
        return type
                .let {
                    when (it) {
                        UnknownType -> it
                        VoidType -> it
                        is NumberType -> it
                        is InlineCType -> it
                        is ConstType -> it.visitConstType(typeAnalyzer)
                        is PointerType -> it.visitPointerType(typeAnalyzer)
                        is FunctionType -> it.visitFunctionType(typeAnalyzer)
                        is NamedType -> it.visitNamedType(table::getType, typeAnalyzer)
                        else -> throw Exception("Expected type, found $it")
                    }
                }
    }
}

private fun Analyzer.analyzeIdentifierFunctionDeclaration(
        newProgram: LinkedHashMap<String, Declaration>,
        programSymbolTable: ProgramSymbolTable,
        symbolTable: SymbolTable,
        type: Type,
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
        type: Type,
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
