package quartz.compiler.semantics.visitors

import quartz.compiler.tree.misc.ExternFunctionDeclaration
import quartz.compiler.tree.util.Type
import quartz.compiler.util.Visitor

/**
 * Created by Aedan Smith.
 */

object ExternFunctionDeclarationAnalyzer {
    inline fun analyzeTypes(
            typeAnalyzer: Visitor<Type>,
            externFunctionDeclaration: ExternFunctionDeclaration
    ): ExternFunctionDeclaration {
        return ExternFunctionDeclaration(
                externFunctionDeclaration.name,
                TypeAnalyzer.analyzeFunctionTypes(typeAnalyzer, externFunctionDeclaration.function)
        )
    }
}
