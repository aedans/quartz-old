package quartz.compiler.semantics.visitors.expression

import quartz.compiler.errors.QuartzException
import quartz.compiler.generator.Generator
import quartz.compiler.semantics.symbols.SymbolTable
import quartz.compiler.semantics.symbols.VariableTable
import quartz.compiler.tree.GlobalDeclaration
import quartz.compiler.tree.function.FunctionDeclaration
import quartz.compiler.tree.function.expression.Identifier
import quartz.compiler.tree.misc.ExternFunctionDeclaration
import quartz.compiler.tree.util.Type
import quartz.compiler.util.Visitor

/**
 * Created by Aedan Smith.
 */

object IdentifierAnalyzer {
    // TODO Visitor<Type> -> TypeAnalyzer
    fun analyzeType(typeVisitor: Visitor<Type>, variableTable: VariableTable, identifier: Identifier): Identifier {
        return identifier.run {
            val expectedType = variableTable.getVar(name)
                    ?: throw QuartzException("Could not find variable $name")

            Identifier(name, genericArguments, typeVisitor(expectedType))
        }
    }

    fun getGlobalDeclaration(symbolTable: SymbolTable, identifier: Identifier): GlobalDeclaration? {
        return symbolTable.getGlobalDeclaration(identifier.name)
    }

    inline fun consumeFunctionDeclaration(
            globalDeclaration: GlobalDeclaration?,
            consumer: (FunctionDeclaration) -> Unit
    ) {
        (globalDeclaration as? FunctionDeclaration)?.also { consumer(it) }
    }

    inline fun consumeExternFunctionDeclaration(
            globalDeclaration: GlobalDeclaration?,
            consumer: (ExternFunctionDeclaration) -> Unit
    ) {
        (globalDeclaration as? ExternFunctionDeclaration)?.also { consumer(it) }
    }

    inline fun analyzeFunctionDeclaration(
            generator: Generator,
            globalDeclaration: GlobalDeclaration?,
            analyzer: (Generator, List<Type>, SymbolTable, FunctionDeclaration) -> FunctionDeclaration,
            symbolTable: SymbolTable,
            identifier: Identifier
    ) {
        consumeFunctionDeclaration(globalDeclaration, {
            if (!generator.isDeclared(it)) {
                generator.declare(it)
                generator.generate(analyzer(generator, identifier.genericArguments, symbolTable, it))
            }
        })
    }

    inline fun analyzeExternFunctionDeclaration(
            generator: Generator,
            globalDeclaration: GlobalDeclaration?,
            analyzer: (SymbolTable, ExternFunctionDeclaration) -> ExternFunctionDeclaration,
            symbolTable: SymbolTable
    ) {
        consumeExternFunctionDeclaration(globalDeclaration, {
            if (!generator.isDeclared(it)) {
                generator.declare(it)
                generator.generate(analyzer(symbolTable, it))
            }
        })
    }
}
