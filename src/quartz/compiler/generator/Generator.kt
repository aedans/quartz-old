package quartz.compiler.generator

import quartz.compiler.tree.Program
import java.io.OutputStream

/**
 * Created by Aedan Smith.
 */

object Generator {
    fun generate(outputStream: OutputStream, program: Program) {
        val programOutputStream = ProgramWriter(outputStream)
        program.forEach { programOutputStream.declareDeclaration(it) }
        program.forEach { programOutputStream.generateDeclaration(it) }
    }
}
