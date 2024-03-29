package util

import java.io.File
import java.io.FileOutputStream
import java.io.PrintStream

/**
 * Created by Aedan Smith.
 */

fun File.write(string: String, func: PrintStream.() -> Unit) {
    val file = File(this, "$string.qz")
    file.createNewFile()
    val printStream = PrintStream(FileOutputStream(file))
    printStream.comment("This file was auto-generated by StdGen.kt; do not edit")
    func(printStream)
}

fun PrintStream.function(name: String, argNames: List<String>, type: String, expression: String) {
    println("fn $name${argNames.joinToString(prefix = "", postfix = "", separator = "") { " $it" }}: $type\n" +
            "    $expression")
}

fun PrintStream.externFunction(name: String, type: String) {
    println("extern fn $name: $type")
}

fun PrintStream._typealias(name: String, type: String) {
    println("typealias $name = $type")
}

fun PrintStream.externTypealias(name: String) {
    _typealias(name, name.inlineC())
}

fun PrintStream.externVal(name: String, type: String) {
    function("get_$name", emptyList(), type.func(), "%%$name%%")
}

fun PrintStream.externVar(name: String, type: String) {
    externVal(name, type)
    function("set_$name", listOf("value"), VOID.func(), "%%$name = value%%")
}

fun PrintStream.include(string: String) {
    inlineC { print("\n#include <$string>\n") }
}

fun PrintStream.import(string: String) {
    println("import $string")
}

fun PrintStream.inlineC(func: PrintStream.() -> Unit) {
    print("%%")
    func(this)
    println("%%")
}

fun PrintStream.comment(string: String) {
    println("/* $string */")
}

fun PrintStream.todo(string: String) {
    println("// TODO $string")
}

fun PrintStream.newline() {
    println()
}
