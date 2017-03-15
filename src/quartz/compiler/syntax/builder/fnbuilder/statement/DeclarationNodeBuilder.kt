package quartz.compiler.syntax.builder.fnbuilder.statement

import quartz.compiler.parser.parsers.parsenodes.Declaration
import quartz.compiler.syntax.builder.fnbuilder.expression
import quartz.compiler.syntax.nodes.enodes.CastNode
import quartz.compiler.syntax.nodes.snodes.DeclarationNode
import quartz.compiler.syntax.type.types.Primitives
import quartz.compiler.util.Variable
import quartz.compiler.util.symboltable.SymbolTable

/**
 * Created by Aedan Smith.
 */

fun Declaration.toStatement(symbolTable: SymbolTable): DeclarationNode {
    val expression = this.getNodes()!![0].expression(symbolTable)
    val type = if (this.type == null) { expression.evalType } else { this.type.toType() }

    if (type == Primitives.void) {
        throw RuntimeException("Cannot assign variable ${this.name} to void")
    }

    if (!expression.evalType.canCastTo(type))
        throw RuntimeException("Could not cast ${expression.evalType} to $type")

    symbolTable.add(this.name, Variable(this.name, type))

    return if (expression.evalType != type) {
        DeclarationNode(this.name, type, this.mutable, CastNode(expression, type))
    } else {
        DeclarationNode(this.name, type, this.mutable, expression)
    }
}
