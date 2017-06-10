package quartz.compiler.semantics.analyzers.expression

import quartz.compiler.semantics.analyzers.util.inferType
import quartz.compiler.semantics.types.UnknownType
import quartz.compiler.semantics.util.ExpressionAnalyzer
import quartz.compiler.tree.expression.Expression
import quartz.compiler.tree.expression.expressions.Assignment
import quartz.compiler.tree.util.Type
import quartz.compiler.util.Visitor
import quartz.compiler.util.partial

/**
 * Created by Aedan Smith.
 */

object AssignmentAnalyzer {
    inline fun visitLValue(expressionVisitor: Visitor<Expression>, assignment: Assignment): Assignment {
        return assignment.copy(lvalue = expressionVisitor(assignment.lvalue))
    }

    inline fun visitExpression(expressionVisitor: Visitor<Expression>, assignment: Assignment): Assignment {
        return assignment.copy(expression = expressionVisitor(assignment.expression))
    }

    inline fun analyzeLValue(expressionAnalyzer: ExpressionAnalyzer, assignment: Assignment): Assignment {
        return visitLValue(expressionAnalyzer.partial(UnknownType), assignment)
    }

    inline fun analyzeExpression(expressionAnalyzer: ExpressionAnalyzer, assignment: Assignment, expectedType: Type): Assignment {
        return visitExpression(expressionAnalyzer.partial(expectedType), assignment)
    }

    fun inferTypeFromLValue(assignment: Assignment): Assignment {
        return assignment.inferType { it.lvalue.type }
    }

    fun inferTypeFromExpression(assignment: Assignment): Assignment {
        return assignment.inferType { it.expression.type }
    }
}
