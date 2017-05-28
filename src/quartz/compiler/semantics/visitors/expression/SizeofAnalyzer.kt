package quartz.compiler.semantics.visitors.expression

import quartz.compiler.tree.function.expression.Sizeof
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
