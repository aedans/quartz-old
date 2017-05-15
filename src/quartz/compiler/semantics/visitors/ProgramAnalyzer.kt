package quartz.compiler.semantics.visitors

import quartz.compiler.semantics.contexts.ProgramContext
import quartz.compiler.semantics.util.defaultConstructor
import quartz.compiler.semantics.util.visitor
import quartz.compiler.semantics.util.visitors.programVisitor
import quartz.compiler.util.Visitor

/**
 * Created by Aedan Smith.
 */

object ProgramAnalyzer : Visitor<ProgramContext> by visitor(
        {
            it.copy(context = it.context.run {
                copy(functionDeclarations = functionDeclarations + structDeclarations
                        .filterValues { !it.external }
                        .mapValues { it.value.defaultConstructor() }) }
            )
        },
        FunctionDeclarationAnalyzer.programVisitor(),
        {
            it.copy(program = it.program.copy(inlineCDeclarations = it.context.inlineCDeclarations))
        }
)
