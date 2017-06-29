package quartz.compiler.semantics

import quartz.compiler.errors.QuartzException
import quartz.compiler.errors.errorScope
import quartz.compiler.semantics.tables.SymbolTable
import quartz.compiler.semantics.types.*
import quartz.compiler.semantics.util.analyze.*
import quartz.compiler.semantics.util.analyze.expressions.*
import quartz.compiler.tree.Declaration
import quartz.compiler.tree.declarations.ExternFunctionDeclaration
import quartz.compiler.tree.declarations.FunctionDeclaration
import quartz.compiler.tree.declarations.InlineC
import quartz.compiler.tree.declarations.TypealiasDeclaration
import quartz.compiler.tree.expression.Expression
import quartz.compiler.tree.expression.expressions.*
import quartz.compiler.tree.util.Type
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
                        .visitTypes(this::visitType.partial(table))
                is FunctionDeclaration -> declaration
                        .visitTypes(table, this::visitType)
                        .analyzeBlock(table, this::visitExpression)
                else -> throw Exception("Expected declaration, found $declaration")
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
                    is InlineC -> it
                    is NumberLiteral -> it
                    is StringLiteral -> it
                    is Identifier -> it
                            .inferTypeAs { typeVisitor(table.getVar(name)
                                    ?: throw QuartzException("Could not find variable $name")) }
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
                            .analyzeExpressions(
                                    this::visitExpression,
                                    table,
                                    expectedType
                            )
                    else -> throw Exception("Expected expression, found $it")
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
                    is ConstType -> it.visitConstType(typeAnalyzer)
                    is PointerType -> it.visitPointerType(typeAnalyzer)
                    is FunctionType -> it.visitFunctionType(typeAnalyzer)
                    is NamedType -> it.visitNamedType(table::getType, typeAnalyzer)
                    else -> throw Exception("Expected type, found $it")
                }
            }
        }
    }
}
