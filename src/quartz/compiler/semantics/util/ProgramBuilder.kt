package quartz.compiler.semantics.util

import quartz.compiler.tree.Program

/**
 * Created by Aedan Smith.
 */

class ProgramBuilder(var program: Program) {
    val nameSupplier = (0..Integer.MAX_VALUE).iterator()
}
