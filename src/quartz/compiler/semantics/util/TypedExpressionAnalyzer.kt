package quartz.compiler.semantics.util

import quartz.compiler.tree.function.Expression
import quartz.compiler.tree.util.Type

/**
 * Created by Aedan Smith.
 */

typealias TypedExpressionAnalyzer = (Type?, Expression) -> Expression
