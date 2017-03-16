package quartz.compiler.syntax.nodes

import quartz.compiler.generator.visitID
import quartz.compiler.util.Type

/**
 * Created by Aedan Smith.
 */

class FnDeclaration(val name: String, val args: List<Pair<String, Type>>, val returnType: Type) {
    val statements = mutableListOf<Statement>()

    override fun toString(): String {
        var string ="$name("
        args.forEach { string += it.first + ": " + it.second + ", " }
        string = (if (!args.isEmpty()) string.substring(0, string.length-2) else string) + "): $returnType\n"
        statements.forEach {
            string += "    " + it.toString() + '\n'
        }
        return string
    }

    fun visit(builder: StringBuilder) {
        returnType.visit(builder)
        builder.append(" ")
        name.visitID(builder)
        builder.append("(")
        for (arg in args.dropLast(1)) {
            arg.second.visit(builder)
            builder.append(" ")
            arg.first.visitID(builder)
            builder.append(", ")
        }
        if (!args.isEmpty()) {
            args.last().second.visit(builder)
            builder.append(" ")
            args.last().first.visitID(builder)
        }

        builder.append(")")
    }
}
