package quartz.compiler.semantics.visitors

import quartz.compiler.semantics.contexts.ProgramContext
import quartz.compiler.semantics.util.defaultConstructor

/**
 * Created by Aedan Smith.
 */

object ProgramAnalyzer {
    fun generateDefaultConstructors(context: ProgramContext): ProgramContext {
        return context.copy(context = context.context.run {
            copy(functionDeclarations = functionDeclarations + structDeclarations
                    .filterValues { !it.external }
                    .mapValues { it.value.defaultConstructor() }) }
        )
    }

    fun migrateInlineC(context: ProgramContext): ProgramContext {
        return context.copy(program = context.program.copy(inlineCDeclarations = context.context.inlineCDeclarations))
    }
}
