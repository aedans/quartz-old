package quartz.compiler.generator

import quartz.compiler.tree.Program
import java.io.OutputStream

/**
 * Created by Aedan Smith.
 */

object Generator {
    fun write(program: Program, outputStream: OutputStream) {
        val cStream = ProgramOutputStream(program, outputStream)
        cStream.declare("header") {
            comment("Generated by the Quartz compiler")
        }
        cStream.writeAll()
    }
}
