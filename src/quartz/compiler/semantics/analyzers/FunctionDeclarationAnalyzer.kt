package quartz.compiler.semantics.analyzers

import quartz.compiler.semantics.util.ExpressionAnalyzer
import quartz.compiler.tree.declarations.FunctionDeclaration
import quartz.compiler.tree.expression.expressions.Block

/**
 * Created by Aedan Smith.
 */

object FunctionDeclarationAnalyzer {
    inline fun block(
            expressionAnalyzer: ExpressionAnalyzer,
            functionDeclaration: FunctionDeclaration
    ): FunctionDeclaration {
        return functionDeclaration.copy(block = expressionAnalyzer(
                functionDeclaration.function.returnType, functionDeclaration.block) as Block)
    }
}
