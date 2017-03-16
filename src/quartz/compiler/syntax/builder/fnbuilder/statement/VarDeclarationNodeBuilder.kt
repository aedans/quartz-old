package quartz.compiler.syntax.builder.fnbuilder.statement

import quartz.compiler.parser.parsers.parsenodes.VarDeclarationNode
import quartz.compiler.syntax.builder.fnbuilder.expression
import quartz.compiler.syntax.nodes.enodes.Cast
import quartz.compiler.syntax.nodes.snodes.VarDeclaration
import quartz.compiler.syntax.symboltable.SymbolTable
import quartz.compiler.syntax.type.types.Primitives
import quartz.compiler.util.Variable

/**
 * Created by Aedan Smith.
 */

fun VarDeclarationNode.toStatement(symbolTable: SymbolTable): VarDeclaration {
    val expression = this.getNodes()!![0].expression(symbolTable)
    val type = if (this.type == null) { expression.evalType } else { this.type.toType() }

    if (type == Primitives.void) {
        throw RuntimeException("Cannot assign variable ${this.name} to void")
    }

    if (!expression.evalType.canCastTo(type))
        throw RuntimeException("Could not cast ${expression.evalType} to $type")

    symbolTable.add(this.name, Variable(this.name, type))

    return if (expression.evalType != type) {
        VarDeclaration(name, type, mutable, Cast(expression, type))
    } else {
        VarDeclaration(name, type, mutable, expression)
    }
}
