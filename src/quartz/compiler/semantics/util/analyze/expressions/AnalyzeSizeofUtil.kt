package quartz.compiler.semantics.util.analyze.expressions

import quartz.compiler.tree.expression.expressions.Sizeof
import quartz.compiler.tree.util.Type
import quartz.compiler.util.Visitor

/**
 * Created by Aedan Smith.
 */

inline fun Sizeof.visitSizeofType(typeVisitor: Visitor<Type>): Sizeof {
    return copy(sizeType = typeVisitor(sizeType))
}
