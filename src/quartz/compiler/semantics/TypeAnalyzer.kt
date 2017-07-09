package quartz.compiler.semantics

import quartz.compiler.errors.err
import quartz.compiler.errors.errorScope
import quartz.compiler.errors.except
import quartz.compiler.semantics.tables.FunctionDeclarationSymbolTable
import quartz.compiler.semantics.tables.LetExpressionSymbolTable
import quartz.compiler.semantics.tables.SymbolTable
import quartz.compiler.semantics.types.*
import quartz.compiler.tree.Declaration
import quartz.compiler.tree.declarations.ExternFunctionDeclaration
import quartz.compiler.tree.declarations.FunctionDeclaration
import quartz.compiler.tree.declarations.InlineC
import quartz.compiler.tree.declarations.TypealiasDeclaration
import quartz.compiler.tree.expression.Expression
import quartz.compiler.tree.expression.expressions.*
import quartz.compiler.tree.util.Type
import quartz.compiler.util.Visitor
import quartz.compiler.util.lValueOrError
import quartz.compiler.util.partial

/**
 * Created by Aedan Smith.
 */

object TypeAnalyzer {
    fun visitDeclaration(
            table: SymbolTable,
            declaration: Declaration
    ): Declaration {
        return errorScope({ declaration.name }) {
            when (declaration) {
                is TypealiasDeclaration -> declaration
                is ExternFunctionDeclaration -> declaration
                        .visitTypes(this::visitType.partial(table))
                is FunctionDeclaration -> declaration
                        .analyzeTypes(table, this::visitType)
                        .analyzeExpression(table, this::visitExpression)
                else -> err { "Expected declaration, found $declaration" }
            }
        }
    }

    fun visitExpression(
            table: SymbolTable,
            expectedType: Type?,
            expr: Expression
    ): Expression {
        errorScope({ expr.toString() }) {
            val typeVisitor = this::visitType.partial(table)
            val expressionAnalyzer = this::visitExpression.partial(table)
            return expr.let {
                when (it) {
                    EmptyExpression -> it
                    is InlineC -> it
                    is NumberLiteral -> it
                    is StringLiteral -> it
                    is Identifier -> it
                            .resolveType(typeVisitor) { table.getVariableDeclaration(it)?.type }
                    is Sizeof -> it
                            .visitSizeType(typeVisitor)
                    is Cast -> it
                            .visitType(typeVisitor)
                            .analyzeExpression(expressionAnalyzer, expectedType)
                    is UnaryOperation -> it
                            .analyzeExpression(expressionAnalyzer, expectedType)
                    is BinaryOperation -> it
                            .analyzeExpr1(expressionAnalyzer, expectedType)
                            .analyzeExpr2(expressionAnalyzer, expectedType)
                    is ExpressionPair -> it
                            .analyzeExpr1(expressionAnalyzer)
                            .analyzeExpr2(expressionAnalyzer, expectedType)
                    is Assignment -> it
                            .analyzeLValue(expressionAnalyzer)
                            .analyzeExpression(expressionAnalyzer, expectedType)
                    is FunctionCall -> it
                            .analyzeExpression(expressionAnalyzer)
                            .analyzeArguments(expressionAnalyzer)
                    is IfExpression -> it
                            .analyzeCondition(expressionAnalyzer)
                            .analyzeIfTrue(expressionAnalyzer, expectedType)
                            .analyzeIfFalse(expressionAnalyzer, expectedType)
                    is LetExpression -> it
                            .visitVariableType(typeVisitor)
                            .analyzeValue(expressionAnalyzer)
                            .inferVariableTypeFromExpression()
                            .visitVariableType(typeVisitor)
                            .analyzeExpression(this::visitExpression, table, expectedType)
                    else -> err { "Expected expression, found $it" }
                }
            }
                    .verifyType(expectedType)
        }
    }

    fun visitType(
            table: SymbolTable,
            type: Type
    ): Type {
        errorScope({ type.toString() }) {
            val typeAnalyzer = this::visitType.partial(table)
            return type.let {
                when (it) {
                    VoidType -> it
                    is NumberType -> it
                    is InlineCType -> it
                    is ConstType -> it.visitType(typeAnalyzer)
                    is PointerType -> it.visitType(typeAnalyzer)
                    is FunctionType -> it.visitTypes(typeAnalyzer)
                    is NamedType -> it.resolveNamedType(typeAnalyzer) { table.getTypeDeclaration(it)?.type }
                    else -> err { "Expected type, found $it" }
                }
            }
        }
    }

    //
    // visitDeclaration util
    //
    inline fun FunctionDeclaration.analyzeTypes(
            table: SymbolTable,
            typeAnalyzer: (SymbolTable, Type) -> Type
    ): FunctionDeclaration {
        val symbolTable = FunctionDeclarationSymbolTable(table, this)
        val typeVisitor = typeAnalyzer.partial(symbolTable)
        return copy(args = argNames zip argTypes.map(typeVisitor), returnType = returnType.let(typeVisitor))
    }

    inline fun FunctionDeclaration.analyzeExpression(
            table: SymbolTable,
            expressionAnalyzer: (SymbolTable, Type?, Expression) -> Expression
    ): FunctionDeclaration {
        val symbolTable = FunctionDeclarationSymbolTable(table, this)
        val expected = if (returnType == VoidType) null else returnType
        return copy(expression = expressionAnalyzer(symbolTable, expected, expression))
    }

    inline fun ExternFunctionDeclaration.visitTypes(typeVisitor: Visitor<Type>): ExternFunctionDeclaration {
        return copy(args = args.map(typeVisitor), returnType = returnType.let(typeVisitor))
    }

    //
    // visitExpression util
    //
    fun Expression.verifyType(type: Type?): Expression {
        val thisType = this.type
        return when {
            type == null -> this
            thisType == null -> this
            type.isConvertibleTo(thisType) -> this
            thisType.isConvertibleTo(type) -> this
            else -> except { "Could not cast $this (${this.type}) to $type" }
        }
    }

    inline fun Identifier.resolveType(typeVisitor: Visitor<Type>, getVar: (String) -> Type?): Identifier {
        return copy(type = typeVisitor(getVar(name) ?: except { "Could not find variable $name" }))
    }

    inline fun Sizeof.visitSizeType(typeVisitor: Visitor<Type>): Sizeof {
        return copy(sizeType = sizeType.let(typeVisitor))
    }

    inline fun Cast.visitType(typeVisitor: Visitor<Type>): Cast {
        return copy(type = type.let(typeVisitor))
    }

    inline fun Cast.analyzeExpression(expressionAnalyzer: (Type?, Expression) -> Expression, expectedType: Type?): Cast {
        return copy(expression = expression.let(expressionAnalyzer.partial(expectedType)))
    }

    inline fun UnaryOperation.analyzeExpression(expressionAnalyzer: (Type?, Expression) -> Expression, expectedType: Type?): UnaryOperation {
        return copy(expression = expression.let(expressionAnalyzer.partial(expectedType)))
    }

    inline fun BinaryOperation.analyzeExpr1(expressionAnalyzer: (Type?, Expression) -> Expression, expectedType: Type?): BinaryOperation {
        return copy(expr1 = expr1.let(expressionAnalyzer.partial(expectedType)))
    }

    inline fun BinaryOperation.analyzeExpr2(expressionAnalyzer: (Type?, Expression) -> Expression, expectedType: Type?): BinaryOperation {
        return copy(expr2 = expr2.let(expressionAnalyzer.partial(expectedType)))
    }

    inline fun ExpressionPair.analyzeExpr1(expressionAnalyzer: (Type?, Expression) -> Expression): ExpressionPair {
        return copy(expr1 = expr1.let(expressionAnalyzer.partial(null)))
    }

    inline fun ExpressionPair.analyzeExpr2(expressionAnalyzer: (Type?, Expression) -> Expression, expectedType: Type?): ExpressionPair {
        return copy(expr2 = expr2.let(expressionAnalyzer.partial(expectedType)))
    }

    inline fun Assignment.analyzeLValue(expressionAnalyzer: (Type?, Expression) -> Expression): Assignment {
        return copy(lvalue = lvalue.let(expressionAnalyzer.partial(null)).lValueOrError())
    }

    inline fun Assignment.analyzeExpression(expressionAnalyzer: (Type?, Expression) -> Expression, expectedType: Type?): Assignment {
        return copy(expression = expression.let(expressionAnalyzer.partial(expectedType)))
    }

    inline fun FunctionCall.analyzeExpression(expressionAnalyzer: (Type?, Expression) -> Expression): FunctionCall {
        return copy(expression = expression.let(expressionAnalyzer.partial(null)))
    }

    inline fun FunctionCall.analyzeArguments(expressionAnalyzer: (Type?, Expression) -> Expression): FunctionCall {
        val function = expression.type as? FunctionType
                ?: except { "Could not call ${expression.type}" }

        if (!function.vararg && function.args.size != args.size)
            except { "Incorrect number of arguments for $this" }

        val expressions = (args zip function.args +
                arrayOfNulls<Type>(args.size - function.args.size))
                .map { expressionAnalyzer(it.second, it.first) }

        val newType = function.returnType

        return FunctionCall(expression, expressions, newType)
    }

    inline fun IfExpression.analyzeCondition(expressionAnalyzer: (Type, Expression) -> Expression): IfExpression {
        // TODO BoolType
        return copy(condition = condition.let(expressionAnalyzer.partial(IntType)))
    }

    inline fun IfExpression.analyzeIfTrue(expressionAnalyzer: (Type?, Expression) -> Expression, expectedType: Type?): IfExpression {
        return copy(ifTrue = ifTrue.let(expressionAnalyzer.partial(expectedType)))
    }

    inline fun IfExpression.analyzeIfFalse(expressionAnalyzer: (Type?, Expression) -> Expression, expectedType: Type?): IfExpression {
        return copy(ifFalse = ifFalse?.let(expressionAnalyzer.partial(expectedType)))
    }

    inline fun LetExpression.visitVariableType(typeVisitor: Visitor<Type>): LetExpression {
        return copy(variableType = variableType?.let(typeVisitor))
    }

    inline fun LetExpression.analyzeValue(expressionAnalyzer: (Type?, Expression) -> Expression): LetExpression {
        return copy(value = value?.let(expressionAnalyzer.partial(variableType)))
    }

    inline fun LetExpression.analyzeExpression(
            expressionAnalyzer: (SymbolTable, Type?, Expression) -> Expression,
            symbolTable: SymbolTable,
            expectedType: Type?
    ): LetExpression {
        return copy(expression = expression.let(
                expressionAnalyzer.partial(LetExpressionSymbolTable(symbolTable, this)).partial(expectedType)
        ))
    }

    fun LetExpression.inferVariableTypeFromExpression(): LetExpression {
        return copy(variableType = value?.type ?: variableType)
    }

    //
    // visitType util
    //
    inline fun NamedType.resolveNamedType(typeVisitor: Visitor<Type>, typeProvider: (String) -> Type?): Type {
        return typeVisitor(typeProvider(string)
                ?: except { "Unknown type $string" })
    }

    inline fun ConstType.visitType(typeVisitor: Visitor<Type>): ConstType {
        return copy(type = type.let(typeVisitor))
    }

    inline fun PointerType.visitType(typeVisitor: Visitor<Type>): PointerType {
        return copy(type = type.let(typeVisitor))
    }

    inline fun FunctionType.visitTypes(typeVisitor: Visitor<Type>): FunctionType {
        return copy(args = args.map(typeVisitor), returnType = returnType.let(typeVisitor))
    }
}
