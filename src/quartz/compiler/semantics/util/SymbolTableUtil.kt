package quartz.compiler.semantics.util

import quartz.compiler.semantics.symbols.SymbolTable
import quartz.compiler.semantics.types.type
import quartz.compiler.tree.GlobalDeclaration
import quartz.compiler.tree.Program
import quartz.compiler.tree.function.FunctionDeclaration
import quartz.compiler.tree.function.expression.Identifier
import quartz.compiler.tree.util.Type

/**
 * Created by Aedan Smith.
 */

fun SymbolTable.withVar(varName: String, type: Type): SymbolTable {
    return object : SymbolTable by this {
        override fun getVar(name: String): Type? {
            return if (name == varName) type else this@withVar.getVar(name)
        }
    }
}

fun SymbolTable.withVars(varNames: Map<String, Type>): SymbolTable {
    return object : SymbolTable by this {
        override fun getVar(name: String): Type? {
            return varNames[name] ?: this@withVars.getVar(name)
        }
    }
}

fun SymbolTable.withTypes(types: Map<String, Type>): SymbolTable {
    return object : SymbolTable by this {
        override fun getType(name: String): Type? {
            return types[name] ?: this@withTypes.getType(name)
        }
    }
}

fun Program.symbolTable(): SymbolTable {
    val program = this
    return object : SymbolTable {
        override fun getGlobalDeclaration(name: String): GlobalDeclaration? {
            return program.functionDeclarations[name]
                    ?: program.externFunctionDeclarations[name]
                    ?: program.typealiasDeclarations[name]
        }

        override fun getType(name: String): Type? {
            return program.typealiasDeclarations[name]?.aliasedType
        }

        override fun getVar(name: String): Type? {
            return program.functionDeclarations[name]?.type()
                    ?: program.externFunctionDeclarations[name]?.type()
        }
    }
}

fun FunctionDeclaration.symbolTable(
        symbolTable: SymbolTable,
        genericArguments: List<Type>
): SymbolTable {
    return symbolTable
            .withVars(argNames.zip(function.args?.filterNotNull() ?: emptyList()).toMap())
            .withTypes(generics.zip(genericArguments).toMap())
}

fun Identifier.symbolTable(
        symbolTable: SymbolTable,
        generics: List<String>
): SymbolTable {
    return symbolTable
            .withTypes(generics.zip(genericArguments).toMap())
}
