package quartz.compiler.parser.parsers.parsenodes

import quartz.compiler.parser.ParseNode
import quartz.compiler.util.ProtoType
import java.lang.reflect.Type

/**
 * Created by Aedan Smith.
 */

data class NumberLiteral(val value: String, val type: ProtoType) : ParseNode {
    override fun add(node: ParseNode) {
        throw RuntimeException("Could not add $node to $this")
    }

    override fun getNodes(): Nothing? {
        return null
    }
}
