package quartz.compiler.syntax.nodes

/**
 * Created by Aedan Smith.
 */

interface StatementNode {
    fun visit(builder: StringBuilder)
}
