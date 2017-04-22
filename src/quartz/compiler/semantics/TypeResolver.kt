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
fun Program.resolveTypes(): Program {
    return errorScope({ "type resolver" }) {
        Program(
                functionDeclarations.mapValues { it.value.resolveTypes(symbolTable) },
                externFunctionDeclarations.mapValues { it.value.resolveTypes(symbolTable) },
                structDeclarations.mapValues { it.value.resolveTypes(symbolTable) },
                typealiasDeclarationDeclarations.mapValues { it.value.resolveTypes(symbolTable) },
                inlineCNodes
        )
    }
}

private fun FunctionDeclaration.resolveTypes(symbolTable: SymbolTable): FunctionDeclaration {
    return errorScope({ "function $name" }) {
        val localSymbolTable = localSymbolTable(symbolTable)
        this.mapTypes { it?.resolve(localSymbolTable) }
    }
}

private fun ExternFunctionDeclaration.resolveTypes(symbolTable: SymbolTable): ExternFunctionDeclaration {
    return errorScope({ "extern function $name" }) {
        this.mapTypes { it?.resolve(symbolTable) }
    }
}

private fun StructDeclaration.resolveTypes(symbolTable: SymbolTable): StructDeclaration {
    return errorScope({ "struct declaration $name" }) {
        val localSymbolTable = localSymbolTable(symbolTable)
        this.mapTypes { it?.resolve(localSymbolTable) }
    }
}

private fun TypealiasDeclaration.resolveTypes(symbolTable: SymbolTable): TypealiasDeclaration {
    return errorScope({ "typealias declaration $name" }) {
        TypealiasDeclaration(name, aliasedType.resolve(symbolTable)!!, external)
    }
}

fun Type?.resolve(symbolTable: SymbolTable): Type? {
    return if (this == null) this else when (this) {
        is AliasedType -> AliasedType(string, type.resolve(symbolTable)!!, external)
        is ConstType -> ConstType(type.resolve(symbolTable)!!)
        is FunctionType -> function.localSymbolTable(symbolTable).run {
            FunctionType(Function(
                    function.args.map { it.resolve(this)!! },
                    function.returnType.resolve(this),
                    function.vararg
            ))
        }
        is PointerType -> PointerType(type.resolve(symbolTable)!!)
        is NumberType -> this
        is VoidType -> this
        is StructType -> StructType(
                string,
                this.members.mapValues { StructMember(it.value.name, it.value.type.resolve(symbolTable)!!, it.value.mutable) }
        )
        is UnresolvedType -> symbolTable.getType(string)?.mapTypes { it?.resolve(symbolTable) }
        else -> throw QuartzException("Unexpected type $this")
    }
}
