package quartz.compiler.generator

import quartz.compiler.tree.Program
import java.io.OutputStream
import java.io.PrintStream

/**
 * Created by Aedan Smith.
 */

class ProgramOutputStream(val program: Program, outputStream: OutputStream) {
    private val identifierChars = { c: Char -> c in 'a'..'z' || c in 'A'..'Z' || c == '_' || c in '0'..'9' }
    private val declared = HashSet<String>()
    private var lastChar = ' '
    private var indent = 0
    val printStream = PrintStream(outputStream)

    fun declare(name: String, function: ProgramOutputStream.() -> Unit) {
        if (!declared.contains(name)) {
            declared.add(name)
            this.function()
        }
    }

    fun margin(function: ProgramOutputStream.() -> Unit) {
        newline()
        function()
        newline()
    }

    fun braces(function: ProgramOutputStream.() -> Unit) {
        string("{")
        indent++
        function()
        indent--
        newline()
        string("}")
    }

    fun parentheses(function: ProgramOutputStream.() -> Unit) {
        string("(")
        function()
        string(")")
    }

    fun comment(string: String) {
        string("/* $string */\n")
    }

    fun name(string: Any) {
        if (identifierChars(lastChar))
            string(" ")
        string(string)
    }

    fun newline() {
        string('\n')
        for (i in 0 until indent) {
            string('\t')
        }
    }

    fun string(string: Any) {
        string(string.toString())
    }

    fun string(string: String) {
        printStream.print(string)
        lastChar = if (string.isNotEmpty()) string.last() else ' '
    }
}
