package quartz.compiler.semantics.util.visitors

import quartz.compiler.errors.QuartzException
import quartz.compiler.semantics.contexts.FunctionDeclarationContext
import quartz.compiler.semantics.contexts.ProgramContext
import quartz.compiler.util.Visitor

/**
 * Created by Aedan Smith.
 */

fun Visitor<FunctionDeclarationContext>.programVisitor(): Visitor<ProgramContext> {
    val functionVisitor = this
    return { programContext ->
        (programContext.context.functionDeclarations["main"] ?: throw QuartzException("Could not find function main"))
                .let { functionVisitor(FunctionDeclarationContext(it, programContext, emptyList())) }
                .let { it.programContext.copy(program = it.programContext.program + it.functionDeclaration) }
    }
}
