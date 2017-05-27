package quartz.compiler.semantics.visitors

import quartz.compiler.semantics.contexts.ProgramContext

/**
 * Created by Aedan Smith.
 */

object ProgramAnalyzer {
    fun migrateInlineC(context: ProgramContext): ProgramContext {
        return context.copy(program = context.program.copy(inlineCDeclarations = context.context.inlineCDeclarations))
    }
}
