package quartz.compiler.semantics

import quartz.compiler.errors.QuartzException
import quartz.compiler.semantics.analyzer.function.analyze
import quartz.compiler.semantics.util.ProgramBuilder
import quartz.compiler.tree.Program

/**
 * Created by Aedan Smith.
 */

fun Program.analyze(): Program {
    return generateConstructors().run {
        val programBuilder = ProgramBuilder(Program())
        inlineCDeclarations.forEach { programBuilder.program += it }
        functionDeclarations["main"]
                ?.analyze(this, programBuilder)
                ?.also { programBuilder.program += it }
                ?: throw QuartzException("Could not find function main")
        programBuilder.program
    }
}
