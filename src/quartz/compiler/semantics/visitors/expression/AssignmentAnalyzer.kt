package quartz.compiler.semantics.visitors.expression

import quartz.compiler.semantics.util.ExpressionAnalyzer
import quartz.compiler.semantics.visitors.util.inferType
import quartz.compiler.tree.function.Expression
import quartz.compiler.tree.function.expression.Assignment
import quartz.compiler.tree.util.Type
import quartz.compiler.util.Visitor
import quartz.compiler.util.curried

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
        return visitLValue(expressionAnalyzer.curried(null), assignment)
    }

    inline fun analyzeExpression(expressionAnalyzer: ExpressionAnalyzer, assignment: Assignment, expectedType: Type?): Assignment {
        return visitExpression(expressionAnalyzer.curried(expectedType), assignment)
    }

    fun inferTypeFromLValue(assignment: Assignment): Assignment {
        return assignment.inferType { it.lvalue.type }
    }

    fun inferTypeFromExpression(assignment: Assignment): Assignment {
        return assignment.inferType { it.expression.type }
    }
}
