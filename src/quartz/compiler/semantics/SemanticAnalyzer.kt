package quartz.compiler.semantics

import quartz.compiler.errors.err
import quartz.compiler.errors.except
import quartz.compiler.semantics.tables.ProgramSymbolTable
import quartz.compiler.semantics.tables.SymbolTable
import quartz.compiler.semantics.types.*
import quartz.compiler.tree.Declaration
import quartz.compiler.tree.Program
import quartz.compiler.tree.declarations.ExternFunctionDeclaration
import quartz.compiler.tree.declarations.FunctionDeclaration
import quartz.compiler.tree.declarations.InlineC
import quartz.compiler.tree.declarations.TypealiasDeclaration
import quartz.compiler.tree.expression.Expression
import quartz.compiler.tree.expression.expressions.*
import quartz.compiler.tree.util.Type

/**
 * Created by Aedan Smith.
 */

object SemanticAnalyzer {
    fun analyzeProgram(program: Program): Program {
        val programSymbolTable = ProgramSymbolTable(program)
        val main = programSymbolTable.functionDeclarations["main"]
                ?: except { "Could not find function main" }
        val newProgram = mutableMapOf<String, Declaration>()
        main.analyze(newProgram, programSymbolTable)
        return programSymbolTable.inlineCDeclarations + newProgram.values
    }

    private fun Declaration.analyze(
            newProgram: MutableMap<String, Declaration>,
            table: SymbolTable
    ) {
        TypeAnalyzer.visitDeclaration(table, this).run {
            newProgram += name to this
            when (this) {
                is ExternFunctionDeclaration -> {
                    analyzeFunction(args, returnType, newProgram, table)
                }
                is FunctionDeclaration -> {
                    analyzeFunction(argTypes, returnType, newProgram, table)
                    expression.analyze(newProgram, table)
                }
                is TypealiasDeclaration -> {
                    aliasedType.analyze(newProgram, table)
                }
                else -> err { "Expected declaration, found $this" }
            }
        }
    }

    private fun Expression.analyze(
            newProgram: MutableMap<String, Declaration>,
            table: SymbolTable
    ) {
        return when (this) {
            EmptyExpression -> {}
            is InlineC -> {}
            is NumberLiteral -> {}
            is StringLiteral -> {}
            is Sizeof -> {
                type.analyze(newProgram, table)
            }
            is Identifier -> {
                analyze(newProgram, table)
            }
            is Cast -> {
                type.analyze(newProgram, table)
                expression.analyze(newProgram, table)
            }
            is ReturnExpression -> {
                expression.analyze(newProgram, table)
            }
            is UnaryOperation -> {
                expression.analyze(newProgram, table)
            }
            is BinaryOperation -> {
                expr1.analyze(newProgram, table)
                expr2.analyze(newProgram, table)
            }
            is ExpressionPair -> {
                expr1.analyze(newProgram, table)
                expr2.analyze(newProgram, table)
            }
            is Assignment -> {
                lvalue.analyze(newProgram, table)
                expression.analyze(newProgram, table)
            }
            is FunctionCall -> {
                expression.analyze(newProgram, table)
                args.forEach { it.analyze(newProgram, table) }
            }
            is IfExpression -> {
                condition.analyze(newProgram, table)
                ifTrue.analyze(newProgram, table)
                ifFalse?.analyze(newProgram, table) ?: Unit
            }
            is LetExpression -> {
                value?.analyze(newProgram, table)
                variableType.analyze(newProgram, table)
                expression.analyze(newProgram, table)
            }
            else -> err { "Expected expression, found $this" }
        }
    }

    private fun Type?.analyze(
            newProgram: MutableMap<String, Declaration>,
            table: SymbolTable
    ) {
        return when (this) {
            null -> {}
            is VoidType -> {}
            is NumberType -> {}
            is InlineCType -> {}
            is ConstType -> type.analyze(newProgram, table)
            is PointerType -> type.analyze(newProgram, table)
            is NamedType -> analyze(newProgram, table)
            is FunctionType -> analyzeFunction(args, returnType, newProgram, table)
            else -> err { "Expected type, found $this" }
        }
    }

    private fun analyzeFunction(
            args: List<Type>?,
            returnType: Type,
            newProgram: MutableMap<String, Declaration>,
            declarationContext: SymbolTable
    ) {
        returnType.analyze(newProgram, declarationContext)
        args?.forEach { it.analyze(newProgram, declarationContext) }
    }

    private fun Identifier.analyze(
            newProgram: MutableMap<String, Declaration>,
            symbolTable: SymbolTable
    ) {
        val declaration = symbolTable.getDeclaration(name) ?: return
        if (!newProgram.contains(name)) {
            declaration.analyze(newProgram, symbolTable)
        }
    }

    private fun NamedType.analyze(
            newProgram: MutableMap<String, Declaration>,
            symbolTable: SymbolTable
    ) {
        val declaration = symbolTable.getDeclaration(string) ?: return
        if (!newProgram.contains(string)) {
            declaration.analyze(newProgram, symbolTable)
        }
    }
}
