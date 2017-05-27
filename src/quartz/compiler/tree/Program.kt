package quartz.compiler.tree

import quartz.compiler.tree.function.FunctionDeclaration
import quartz.compiler.tree.misc.ExternFunctionDeclaration
import quartz.compiler.tree.misc.InlineC
import quartz.compiler.tree.misc.TypealiasDeclaration

/**
 * Created by Aedan Smith.
 */

data class Program(
        val inlineCDeclarations: List<InlineC>,
        val functionDeclarations: Map<String, FunctionDeclaration>,
        val externFunctionDeclarations: Map<String, ExternFunctionDeclaration>,
        val typealiasDeclarations: Map<String, TypealiasDeclaration>
) {
    constructor() : this(emptyList(), emptyMap(), emptyMap(), emptyMap())

    operator fun plus(inlineC: InlineC): Program {
        return copy(inlineCDeclarations = inlineCDeclarations + inlineC)
    }

    operator fun plus(functionDeclaration: FunctionDeclaration): Program {
        return copy(functionDeclarations = functionDeclarations + (functionDeclaration.name to functionDeclaration))
    }

    operator fun plus(externFunctionDeclaration: ExternFunctionDeclaration): Program {
        return copy(externFunctionDeclarations = externFunctionDeclarations + (externFunctionDeclaration.name to externFunctionDeclaration))
    }

    operator fun plus(typealiasDeclaration: TypealiasDeclaration): Program {
        return copy(typealiasDeclarations = typealiasDeclarations + (typealiasDeclaration.name to typealiasDeclaration))
    }

    operator fun plus(program: Program): Program {
        return copy(
                inlineCDeclarations + program.inlineCDeclarations,
                functionDeclarations + program.functionDeclarations,
                externFunctionDeclarations + program.externFunctionDeclarations,
                typealiasDeclarations + program.typealiasDeclarations
        )
    }

    override fun toString(): String {
        var s = ""
        inlineCDeclarations.forEach { s += "%%${it.src}%%\n\n" }
        functionDeclarations.forEach { s += "${it.value}\n\n" }
        externFunctionDeclarations.forEach { s += "${it.value}\n\n" }
        typealiasDeclarations.forEach { s += "${it.value}\n\n" }
        return s
    }
}