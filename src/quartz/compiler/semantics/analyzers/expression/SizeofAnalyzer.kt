package quartz.compiler.semantics.analyzers.expression

import quartz.compiler.tree.expression.expressions.Sizeof
import quartz.compiler.tree.util.Type
import quartz.compiler.util.Visitor

/**
 * Created by Aedan Smith.
 */

object SizeofAnalyzer {
    inline fun visitSizeofType(typeVisitor: Visitor<Type>, sizeof: Sizeof): Sizeof {
        return sizeof.copy(sizeType = typeVisitor(sizeof.sizeType))
    }
}