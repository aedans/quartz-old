package quartz.compiler.generator

import quartz.compiler.generator.semantics.unwrapExpressions
import quartz.compiler.generator.semantics.verifyNames
import quartz.compiler.syntax.tree.ProgramNode
import java.io.OutputStream

/**
 * Created by Aedan Smith.
 */

object Generator {
    fun write(programNode: ProgramNode, outputStream: OutputStream) {
        val newProgramNode = programNode
                .unwrapExpressions()
                .verifyNames()
        val cStream = ProgramOutputStream(newProgramNode, outputStream)
        cStream.declare("header") {
            comment("Generated by the Quartz compiler")
        }
        cStream.writeAll()
    }
}
