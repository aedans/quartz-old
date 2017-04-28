package quartz.compiler.semantics

import quartz.compiler.errors.errorScope
import quartz.compiler.semantics.analyzer.verify
import quartz.compiler.tree.Program
import quartz.compiler.tree.function.FunctionDeclaration

/**
 * Created by Aedan Smith.
 */

fun FunctionDeclaration.analyze(program: Program): FunctionDeclaration {
    return errorScope({ "type verifier" }) {
        this.verify(program.symbolTable)
    }
}
