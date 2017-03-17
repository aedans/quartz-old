package quartz.compiler.tree

import quartz.compiler.util.Type

/**
 * Created by Aedan Smith.
 */

interface ExpressionNode : StatementNode {
    var type: Type?
}
