package quartz.compiler.generator.program

import quartz.compiler.generator.util.visit
import quartz.compiler.generator.util.visitName
import quartz.compiler.syntax.tree.function.ExpressionNode
import quartz.compiler.syntax.tree.function.FnDeclarationNode
import quartz.compiler.syntax.tree.function.StatementNode
import quartz.compiler.syntax.tree.function.expression.*
import quartz.compiler.syntax.tree.function.statement.*
import quartz.compiler.util.Function
import quartz.compiler.util.times
import quartz.compiler.visitor.program.function.visit

/**
 * Created by Aedan Smith.
 */

fun FnDeclarationNode.visit(string: StringBuilder) {
    returnType.visit(string)
    string.append(' ')
    name.visitName(string)
    args.visit(string)
    string.appendln('{')
    statements.forEach {
        string.append("    ")
        it.visit(string, 1)
        string.appendln(";")
    }
    string.appendln('}')
}

fun FnDeclarationNode.visitTypedef(string: StringBuilder) {
    Function(name, args.map { it.second }, returnType, false).visitTypedef(string)
}

fun FnDeclarationNode.visitPrototype(string: StringBuilder) {
    returnType.visit(string)
    string.append(' ')
    name.visitName(string)
    args.visit(string)
    string.appendln(";")
}

fun StatementNode.visit(string: StringBuilder, depth: Int) {
    this.visit(
            { visit(string); this },
            { visit(string); this },
            { visit(string); this },
            { visit(string, depth); this },
            { visit(string, depth); this },
            { visit(string); this },
            { visit(string); this }
    )
}

fun VarDeclarationNode.visit(string: StringBuilder) {
    (type ?: throw Exception("Unknown type for $this")).visit(string)
    string.append(' ')
    name.visitName(string)
    if (expression != null) {
        string.append(" = ")
        expression.visit(string)
    }
}

fun ReturnNode.visit(string: StringBuilder) {
    string.append("return ")
    expressionNode.visit(string)
}

fun IfStatementNode.visit(string: StringBuilder, depth: Int) {
    string.append("if (")
    test.visit(string)
    string.appendln("){")
    for (statement in trueStatements) {
        string.append("    " * (depth + 1))
        statement.visit(string, depth + 1)
        string.appendln(";")
    }
    string.append(("    " * depth) + "}")
    if (!falseStatements.isEmpty()) {
        string.appendln("else{")
        for (statement in falseStatements) {
            string.append("    " * (depth + 1))
            statement.visit(string, depth + 1)
            string.appendln(";")
        }
        string.append(("    " * depth) + "}")
    }
}

fun WhileLoopNode.visit(string: StringBuilder, depth: Int) {
    string.append("while (")
    test.visit(string)
    string.appendln("){")
    for (statement in statements) {
        string.append("    " * (depth + 1))
        statement.visit(string, depth + 1)
        string.appendln(";")
    }
    string.append(("    " * depth) + "}")
}

fun ExpressionNode.visit(string: StringBuilder) {
    this.visit(
            { visit(string); this },
            { visit(string); this },
            { visit(string); this },
            { visit(string); this },
            { visit(string); this },
            { visit(string); this },
            { visit(string); this },
            { visit(string); this },
            { visit(string); this },
            { visit(string); this }
    )
}

fun NumberLiteralNode.visit(string: StringBuilder){
    string.append(this.string)
}

fun StringLiteralNode.visit(string: StringBuilder) {
    string.append("\"${this.string}\"")
}

fun IdentifierNode.visit(string: StringBuilder) {
    name.visitName(string)
}

fun CastNode.visit(string: StringBuilder) {
    string.append('(')
    (type ?: throw Exception("Unknown type for $this")).visit(string)
    string.append(") (")
    expression.visit(string)
    string.append(')')
}

fun UnaryOperatorNode.visit(string: StringBuilder) {
    string.append(id)
    string.append('(')
    expression.visit(string)
    string.append(')')
}

fun BinaryOperatorNode.visit(string: StringBuilder) {
    when (id) {
        BinaryOperatorNode.ID.ARRAY_ACCESS -> {
            string.append('(')
            expr1.visit(string)
            string.append(")[")
            expr2.visit(string)
            string.append(']')
        }
        else -> {
            string.append('(')
            expr1.visit(string)
            string.append(')')
            string.append(id)
            string.append('(')
            expr2.visit(string)
            string.append(')')
        }
    }
}

fun MemberAccessNode.visit(string: StringBuilder) {
    expression.visit(string)
    string.append('.')
    name.visitName(string)
}

fun FnCallNode.visit(string: StringBuilder) {
    expression.visit(string)
    string.append('(')
    expressions.dropLast(1).forEach {
        it.visit(string)
        string.append(", ")
    }
    if (!expressions.isEmpty())
        expressions.last().visit(string)
    string.append(')')
}

fun VarAssignmentNode.visit(string: StringBuilder) {
    name.visitName(string)
    string.append(" = ")
    expression.visit(string)
}
