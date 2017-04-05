package quartz.compiler.tree.function

import quartz.compiler.exceptions.QuartzException
import quartz.compiler.tree.GlobalDeclarationNode
import quartz.compiler.util.Function
import quartz.compiler.util.Type

/**
 * Created by Aedan Smith.
 */

class FnDeclarationNode(
        val name: String,
        val argNames: List<String>,
        val function: Function,
        val statements: List<StatementNode> = listOf()
) : GlobalDeclarationNode {
    val argsWithNames by lazy {
        if (argNames.size != function.args.size)
            throw QuartzException("$argNames.size != ${function.args}.size")
        argNames.zip(function.args)
    }

    override fun toString(): String {
        var s = "$name$function"
        statements.forEach { s += '\n' + it.toString(1) }
        return s
    }

    fun mapStatements(function: (StatementNode) -> StatementNode): FnDeclarationNode {
        return FnDeclarationNode(name, argNames, this.function, statements.map(function))
    }

    fun mapExpressions(function: (ExpressionNode) -> ExpressionNode): FnDeclarationNode {
        return mapStatements { it.mapExpressions(function) }
    }

    fun mapTypes(function: (Type?) -> Type?): FnDeclarationNode {
        return FnDeclarationNode(
                name,
                argNames,
                this.function.mapTypes(function),
                statements.map { it.mapTypes(function) }
        )
    }
}
