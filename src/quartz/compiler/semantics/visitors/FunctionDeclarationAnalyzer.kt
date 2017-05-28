package quartz.compiler.semantics.visitors

import quartz.compiler.semantics.symbols.SymbolTable
import quartz.compiler.tree.function.FunctionDeclaration
import quartz.compiler.tree.util.Type
import quartz.compiler.util.Visitor

/**
 * Created by Aedan Smith.
 */

object FunctionDeclarationAnalyzer {
    inline fun visitTypes(typeVisitor: Visitor<Type>, functionDeclaration: FunctionDeclaration): FunctionDeclaration {
        return FunctionDeclaration(
                functionDeclaration.name,
                functionDeclaration.argNames,
                functionDeclaration.generics,
                TypeAnalyzer.analyzeFunctionTypes(typeVisitor, functionDeclaration.function),
                functionDeclaration.block
        )
    }

    fun localSymbolTable(symbolTable: SymbolTable, functionDeclaration: FunctionDeclaration): SymbolTable {
        return object : SymbolTable by symbolTable {
            override fun getVar(name: String): Type? {
                return functionDeclaration.argsWithNames?.firstOrNull { it.first == name }?.second
                        ?: symbolTable.getVar(name)
            }
        }
    }
}
