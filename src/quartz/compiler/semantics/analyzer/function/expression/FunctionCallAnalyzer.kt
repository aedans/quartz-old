package quartz.compiler.semantics.analyzer.function.expression

import quartz.compiler.errors.QuartzException
import quartz.compiler.errors.errorScope
import quartz.compiler.semantics.analyzer.function.analyze
import quartz.compiler.semantics.analyzer.type.asFunction
import quartz.compiler.semantics.util.BlockBuilder
import quartz.compiler.semantics.util.ProgramBuilder
import quartz.compiler.tree.Program
import quartz.compiler.tree.function.expression.Identifier
import quartz.compiler.tree.function.expression.MemberAccess
import quartz.compiler.tree.function.statement.FunctionCall
import quartz.compiler.util.Type

/**
 * Created by Aedan Smith.
 */

fun FunctionCall.analyze(
        blockBuilder: BlockBuilder,
        program: Program,
        programBuilder: ProgramBuilder
): FunctionCall {
    return analyzeTypes(blockBuilder, program, programBuilder)
}

fun FunctionCall.analyzeTypes(
        blockBuilder: BlockBuilder,
        program: Program,
        programBuilder: ProgramBuilder
): FunctionCall {
    return try {
        val newExpression = expression.analyze(blockBuilder, program, programBuilder, null)
        val expressionFunction = newExpression.type.asFunction()?.function
                ?: throw QuartzException("Could not call ${newExpression.type}")
        expressionFunction.args!!

        if (!expressionFunction.vararg && expressionFunction.args.size != args.size)
            throw QuartzException("Incorrect number of arguments for $this")

        val expressions = args.zip(expressionFunction.args +
                arrayOfNulls<Type>(args.size - expressionFunction.args.size))
                .map { it.first.analyze(blockBuilder, program, programBuilder, it.second) }

        val newType = expressionFunction.returnType

        FunctionCall(newExpression, expressions, newType)
    } catch (e: QuartzException) {
        if (expression !is MemberAccess)
            throw e

        resolveDotNotation(blockBuilder, program, programBuilder).analyzeTypes(blockBuilder, program, programBuilder)
    }
}

fun FunctionCall.resolveDotNotation(blockBuilder: BlockBuilder, program: Program, programBuilder: ProgramBuilder): FunctionCall {
    return errorScope({ "dot notation resolver" }) {
        errorScope({ "$this" }) {
            if (expression !is MemberAccess)
                throw QuartzException("Dot notation ambiguity in $this")

            FunctionCall(
                    Identifier(expression.name, null).analyze(blockBuilder, program, programBuilder, null),
                    listOf(expression.expression) + args,
                    type
            )
        }
    }
}
