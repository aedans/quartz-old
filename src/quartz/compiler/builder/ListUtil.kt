package quartz.compiler.builder

import quartz.compiler.parser.QuartzParser
import quartz.compiler.tree.Type

/**
 * Created by Aedan Smith.
 */

fun QuartzParser.AtomicTypeListContext?.toList(): List<Type> {
    return when {
        this == null -> emptyList()
        atomicTypeList() != null -> listOf(atomicType().toType()) + atomicTypeList().toList()
        else -> listOf(atomicType().toType())
    }
}

fun QuartzParser.PackageListContext?.toList(): List<String> {
    return when (this) {
        null -> emptyList()
        else -> listOf(NAME().text) + packageList().toList()
    }
}
