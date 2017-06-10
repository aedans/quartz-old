package quartz.compiler.semantics.util

import quartz.compiler.tree.expression.Expression
import quartz.compiler.tree.util.Type

/**
 * Created by Aedan Smith.
 */

typealias ExpressionAnalyzer = (Type, Expression) -> Expression
