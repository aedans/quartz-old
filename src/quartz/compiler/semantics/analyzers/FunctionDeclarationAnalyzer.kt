package quartz.compiler.semantics.analyzers

import quartz.compiler.semantics.types.UnknownType
import quartz.compiler.semantics.types.VoidType
import quartz.compiler.semantics.util.ExpressionAnalyzer
import quartz.compiler.tree.declarations.FunctionDeclaration
import quartz.compiler.tree.expression.expressions.Block

/**
 * Created by Aedan Smith.
 */

object FunctionDeclarationAnalyzer {
    inline fun analyzeBlock(
            expressionAnalyzer: ExpressionAnalyzer,
            functionDeclaration: FunctionDeclaration
    ): FunctionDeclaration {
        val expected = if (functionDeclaration.function.returnType == VoidType) UnknownType else functionDeclaration.function.returnType
        return functionDeclaration.copy(block = expressionAnalyzer(expected, functionDeclaration.block) as Block)
    }
}
