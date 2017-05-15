package quartz.compiler.semantics

import quartz.compiler.semantics.contexts.ProgramContext
import quartz.compiler.semantics.visitors.ProgramAnalyzer
import quartz.compiler.tree.Program

/**
 * Created by Aedan Smith.
 */

fun Program.analyze(): Program {
    return ProgramAnalyzer(ProgramContext(Program(), this, 0)).program
}
