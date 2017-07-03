package quartz.compiler.semantics

import quartz.compiler.errors.err
import quartz.compiler.errors.errorScope
import quartz.compiler.errors.except
import quartz.compiler.semantics.tables.FunctionDeclarationSymbolTable
import quartz.compiler.semantics.tables.SymbolTable
import quartz.compiler.semantics.types.*
import quartz.compiler.semantics.util.withVar
import quartz.compiler.tree.Declaration
import quartz.compiler.tree.declarations.ExternFunctionDeclaration
import quartz.compiler.tree.declarations.FunctionDeclaration
import quartz.compiler.tree.declarations.InlineC
import quartz.compiler.tree.declarations.TypealiasDeclaration
import quartz.compiler.tree.expression.Expression
import quartz.compiler.tree.expression.expressions.*
import quartz.compiler.tree.util.Type
import quartz.compiler.util.Visitor
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
                is InlineC -> declaration
                is TypealiasDeclaration -> declaration
                is ExternFunctionDeclaration -> declaration
                        .analyzeTypes(this::visitType.partial(table))
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
                            .resolveType(table::getVar, typeVisitor)
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
                    is FunctionType -> it.visitFunctionType(typeAnalyzer)
                    is NamedType -> it.resolveNamedType(table::getType, typeAnalyzer)
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
        return visitFunction { it.visitTypes(typeAnalyzer.partial(symbolTable)) }
    }

    inline fun FunctionDeclaration.analyzeExpression(
            table: SymbolTable,
            expressionAnalyzer: (SymbolTable, Type?, Expression) -> Expression
    ): FunctionDeclaration {
        val symbolTable = FunctionDeclarationSymbolTable(table, this)
        val expected = if (function.returnType == VoidType) null else function.returnType
        return copy(expression = expressionAnalyzer(symbolTable, expected, expression))
    }

    inline fun ExternFunctionDeclaration.analyzeTypes(typeVisitor: Visitor<Type>): ExternFunctionDeclaration {
        return visitFunction { it.visitTypes(typeVisitor) }
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

    inline fun Identifier.resolveType(getVar: (String) -> Type?, typeVisitor: Visitor<Type>): Identifier {
        return copy(type = typeVisitor(getVar(name) ?: except { "Could not find variable $name" }))
    }

    inline fun Cast.analyzeExpression(expressionAnalyzer: (Type?, Expression) -> Expression, expectedType: Type?): Cast {
        return visitExpression(expressionAnalyzer.partial(expectedType))
    }

    inline fun UnaryOperation.analyzeExpression(expressionAnalyzer: (Type?, Expression) -> Expression, expectedType: Type?): UnaryOperation {
        return visitExpression(expressionAnalyzer.partial(expectedType))
    }

    inline fun BinaryOperation.analyzeExpr1(expressionAnalyzer: (Type?, Expression) -> Expression, expectedType: Type?): BinaryOperation {
        return visitExpr1(expressionAnalyzer.partial(expectedType))
    }

    inline fun BinaryOperation.analyzeExpr2(expressionAnalyzer: (Type?, Expression) -> Expression, expectedType: Type?): BinaryOperation {
        return visitExpr2(expressionAnalyzer.partial(expectedType))
    }

    inline fun ExpressionPair.analyzeExpr1(expressionAnalyzer: (Type?, Expression) -> Expression): ExpressionPair {
        return visitExpr1(expressionAnalyzer.partial(null))
    }

    inline fun ExpressionPair.analyzeExpr2(expressionAnalyzer: (Type?, Expression) -> Expression, expectedType: Type?): ExpressionPair {
        return visitExpr2(expressionAnalyzer.partial(expectedType))
    }

    inline fun Assignment.analyzeLValue(expressionAnalyzer: (Type?, Expression) -> Expression): Assignment {
        return visitLValue(expressionAnalyzer.partial(null))
    }

    inline fun Assignment.analyzeExpression(expressionAnalyzer: (Type?, Expression) -> Expression, expectedType: Type?): Assignment {
        return visitExpression(expressionAnalyzer.partial(expectedType))
    }

    inline fun FunctionCall.analyzeExpression(expressionAnalyzer: (Type?, Expression) -> Expression): FunctionCall {
        return visitExpression(expressionAnalyzer.partial(null))
    }

    inline fun FunctionCall.analyzeArguments(expressionAnalyzer: (Type?, Expression) -> Expression): FunctionCall {
        val function = (expression.type as? FunctionType)?.function
                ?: except { "Could not call ${expression.type}" }
        function.args!!

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
        return visitCondition(expressionAnalyzer.partial(IntType))
    }

    inline fun IfExpression.analyzeIfTrue(expressionAnalyzer: (Type?, Expression) -> Expression, expectedType: Type?): IfExpression {
        return visitIfTrue(expressionAnalyzer.partial(expectedType))
    }

    inline fun IfExpression.analyzeIfFalse(expressionAnalyzer: (Type?, Expression) -> Expression, expectedType: Type?): IfExpression {
        return visitIfFalse(expressionAnalyzer.partial(expectedType))
    }

    inline fun LetExpression.analyzeValue(expressionAnalyzer: (Type?, Expression) -> Expression): LetExpression {
        return visitValue(expressionAnalyzer.partial(variableType))
    }

    inline fun LetExpression.analyzeExpression(
            expressionAnalyzer: (SymbolTable, Type?, Expression) -> Expression,
            symbolTable: SymbolTable,
            expectedType: Type?
    ): LetExpression {
        return visitExpression(expressionAnalyzer.partial(symbolTable.withVar(name, variableType ?:
                except { "Could not infer type for $this" }
        )).partial(expectedType))
    }

    fun LetExpression.inferVariableTypeFromExpression(): LetExpression {
        return copy(variableType = value?.type ?: variableType)
    }

    //
    // visitType util
    //
    inline fun NamedType.resolveNamedType(typeProvider: (String) -> Type?, typeVisitor: Visitor<Type>): Type {
        return typeVisitor(typeProvider(string)
                ?: except { "Unknown type $string" })
    }
}
