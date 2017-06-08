package quartz.compiler.semantics

import quartz.compiler.errors.QuartzException
import quartz.compiler.semantics.tables.ProgramSymbolTable
import quartz.compiler.semantics.tables.SymbolTable
import quartz.compiler.semantics.types.type
import quartz.compiler.tree.Declaration
import quartz.compiler.tree.Program
import quartz.compiler.tree.declarations.ExternFunctionDeclaration
import quartz.compiler.tree.declarations.FunctionDeclaration
import quartz.compiler.tree.expression.Expression
import quartz.compiler.tree.expression.expressions.Identifier
import quartz.compiler.tree.util.Type

/**
 * Created by Aedan Smith.
 */

fun Program.analyze(): Program {
    val newProgram = LinkedHashMap<String, Declaration>()
    val programSymbolTable = ProgramSymbolTable(this)
    val analyzer = Analyzer() +
            { a, b, c -> analyzeIdentifierFunctionDeclaration(newProgram, programSymbolTable, a, b, c) } +
            { a, b, c -> analyzeIdentifierExternFunctionDeclaration(newProgram, programSymbolTable, a, b, c) }
    val main = analyzer.analyzeFunctionDeclaration(programSymbolTable, programSymbolTable.functionDeclarations["main"]
            ?: throw QuartzException("Could not find function main."))
    return programSymbolTable.inlineCDeclarations + newProgram.map { it.value } + main
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
