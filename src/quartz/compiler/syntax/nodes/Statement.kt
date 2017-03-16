package quartz.compiler.syntax.nodes

/**
 * Created by Aedan Smith.
 */

interface Statement {
    fun visit(builder: StringBuilder)
}
