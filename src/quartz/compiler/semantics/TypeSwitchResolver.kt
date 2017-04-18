package quartz.compiler.semantics

import quartz.compiler.exceptions.QuartzException
import quartz.compiler.tree.Program
import quartz.compiler.tree.function.statement.Block
import quartz.compiler.tree.function.statement.IfStatement
import quartz.compiler.tree.function.statement.TypeSwitch

/**
 * Created by Aedan Smith.
 */

fun Program.resolveTypeSwitch(): Program {
    return this.mapStatements {
        when (it) {
            is TypeSwitch -> it.resolve()
            else -> it
        }
    }
}

private fun TypeSwitch.resolve(): IfStatement {
    val branch = branches.keys.firstOrNull { it.isInstance(identifier.type!!) }
            ?: throw QuartzException("Could not find branch ${identifier.type} in $this")
    return Block(branches[branch] ?: throw QuartzException("Could not find branch $branch in $branches"))
}
