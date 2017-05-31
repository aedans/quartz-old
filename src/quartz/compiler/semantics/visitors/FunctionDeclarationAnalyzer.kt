package quartz.compiler.semantics.visitors

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

    fun resolveGenerics(genericArguments: List<Type>, declaration: FunctionDeclaration): FunctionDeclaration {
        return FunctionDeclaration(
                declaration.name + genericArguments.joinToString("") { "_${it.descriptiveString}" },
                declaration.argNames,
                emptyList(),
                declaration.function,
                declaration.block
        )
    }
}
