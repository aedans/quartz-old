package quartz.compiler.tree.function.statement

import quartz.compiler.semantics.types.Primitives
import quartz.compiler.tree.function.Statement
import quartz.compiler.tree.function.expression.NumberLiteral

/**
 * Created by Aedan Smith.
 */

class Block(val statements: List<Statement>) : IfStatement(NumberLiteral("1", Primitives.int), statements, emptyList())
