package quartz.compiler.semantics

import quartz.compiler.errors.QuartzException
import quartz.compiler.errors.errorScope
import quartz.compiler.semantics.symboltable.SymbolTable
import quartz.compiler.semantics.symboltable.localSymbolTable
import quartz.compiler.semantics.types.*
import quartz.compiler.tree.Program
import quartz.compiler.tree.function.FunctionDeclaration
import quartz.compiler.tree.misc.ExternFunctionDeclaration
import quartz.compiler.tree.misc.TypealiasDeclaration
import quartz.compiler.tree.struct.StructDeclaration
import quartz.compiler.tree.struct.StructMember
import quartz.compiler.util.Function
import quartz.compiler.util.Type

/**
 * Created by Aedan Smith.
 */
fun Program.generateTypes(): Program {
    return errorScope({ "type resolver" }) {
        Program(
                functionDeclarations.mapValues { it.value.generateTypes(symbolTable) },
                externFunctionDeclarations.mapValues { it.value.generateTypes(symbolTable) },
                structDeclarations.mapValues { it.value.generateTypes(symbolTable) },
                typealiasDeclarationDeclarations.mapValues { it.value.generateTypes(symbolTable) },
                inlineCNodes
        )
    }
}

private fun FunctionDeclaration.generateTypes(symbolTable: SymbolTable): FunctionDeclaration {
    return errorScope({ "function $name" }) {
        val localSymbolTable = localSymbolTable(symbolTable)
        this.mapTypes { it?.generate(localSymbolTable) }
    }
}

private fun ExternFunctionDeclaration.generateTypes(symbolTable: SymbolTable): ExternFunctionDeclaration {
    return errorScope({ "extern function $name" }) {
        this.mapTypes { it?.generate(symbolTable) }
    }
}

private fun StructDeclaration.generateTypes(symbolTable: SymbolTable): StructDeclaration {
    return errorScope({ "struct declaration $name" }) {
        val localSymbolTable = localSymbolTable(symbolTable)
        this.mapTypes { it?.generate(localSymbolTable) }
    }
}

private fun TypealiasDeclaration.generateTypes(symbolTable: SymbolTable): TypealiasDeclaration {
    return errorScope({ "typealias declaration $name" }) {
        TypealiasDeclaration(name, aliasedType.generate(symbolTable)!!, external)
    }
}

fun Type?.generate(symbolTable: SymbolTable): Type? {
    return if (this == null) this else when (this) {
        is AliasedType -> AliasedType(string, type.generate(symbolTable)!!, external)
        is ConstType -> ConstType(type.generate(symbolTable)!!)
        is FunctionType -> function.localSymbolTable(symbolTable).run {
            FunctionType(Function(
                    function.args.map { it.generate(this)!! },
                    function.returnType.generate(this),
                    function.vararg
            ))
        }
        is PointerType -> PointerType(type.generate(symbolTable)!!)
        is NumberType -> this
        is VoidType -> this
        is StructType -> StructType(
                string,
                this.members.mapValues { StructMember(it.value.name, it.value.type.generate(symbolTable)!!, it.value.mutable) }
        )
        is UnresolvedType -> symbolTable.getType(string)?.mapTypes { it?.generate(symbolTable) }
        else -> throw QuartzException("Unexpected type $this")
    }
}
