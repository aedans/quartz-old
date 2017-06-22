package quartz.compiler.semantics.util.analyze

import quartz.compiler.semantics.tables.FunctionDeclarationSymbolTable
import quartz.compiler.semantics.tables.SymbolTable
import quartz.compiler.tree.declarations.FunctionDeclaration
import quartz.compiler.tree.util.Type
import quartz.compiler.util.partial

/**
 * Created by Aedan Smith.
 */

inline fun FunctionDeclaration.visitTypes(
        table: SymbolTable,
        typeAnalyzer: (SymbolTable, Type) -> Type
): FunctionDeclaration {
    val symbolTable = FunctionDeclarationSymbolTable(table, this)
    return FunctionDeclaration(
            name,
            argNames,
            function.visitFunctionTypes(typeAnalyzer.partial(symbolTable)),
            block
    )
}
