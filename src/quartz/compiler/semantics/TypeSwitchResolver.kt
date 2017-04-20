package quartz.compiler.semantics

import quartz.compiler.errors.QuartzException
import quartz.compiler.errors.errorScope
import quartz.compiler.tree.Program
import quartz.compiler.tree.function.statement.Block
import quartz.compiler.tree.function.statement.TypeSwitch

/**
 * Created by Aedan Smith.
 */

fun Program.resolveTypeSwitch(): Program {
    return errorScope({ "typeswitch resolver" }) {
        this.mapStatements {
            when (it) {
                is TypeSwitch -> it.resolve()
                else -> it
            }
        }
    }
}

private fun TypeSwitch.resolve(): Block {
    return errorScope({ "$this" }) {
        val branch = branches.keys.firstOrNull { it.isInstance(identifier.type!!) }
                ?: throw QuartzException("Could not find branch ${identifier.type} in $this")
        branches[branch] ?: throw QuartzException("Could not find branch $branch in $branches")
    }
}
