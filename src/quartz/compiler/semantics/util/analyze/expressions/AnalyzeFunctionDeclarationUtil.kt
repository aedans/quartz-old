package quartz.compiler.semantics.util.analyze.expressions

import quartz.compiler.semantics.types.UnknownType
import quartz.compiler.semantics.types.VoidType
import quartz.compiler.semantics.util.ExpressionAnalyzer
import quartz.compiler.tree.declarations.FunctionDeclaration
import quartz.compiler.tree.expression.expressions.Block

/**
 * Created by Aedan Smith.
 */

inline fun FunctionDeclaration.analyzeBlock(expressionAnalyzer: ExpressionAnalyzer): FunctionDeclaration {
    val expected = if (function.returnType == VoidType) UnknownType else function.returnType
    return copy(block = expressionAnalyzer(expected, block) as Block)
}