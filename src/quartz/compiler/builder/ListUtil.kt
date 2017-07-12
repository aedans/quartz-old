package quartz.compiler.builder

import quartz.compiler.parser.QuartzParser
import quartz.compiler.tree.Expression
import quartz.compiler.tree.Type

/**
 * Created by Aedan Smith.
 */

fun QuartzParser.ExpressionListContext?.toList(): List<Expression> {
    return when (this) {
        null -> emptyList()
        else -> listOf(expression().toExpr()) + expressionList().toList()
    }
}

fun QuartzParser.TypeListContext?.toList(): List<Type> {
    return when {
        this == null -> emptyList()
        vararg != null -> emptyList()
        else -> listOf(type().toType()) + typeList().toList()
    }
}

fun QuartzParser.TypeListContext?.isVararg(): Boolean {
    return this != null && (vararg != null || typeList().isVararg())
}

fun QuartzParser.PackageListContext?.toList(): List<String> {
    return when (this) {
        null -> emptyList()
        else -> listOf(NAME().text) + packageList().toList()
    }
}

fun QuartzParser.NameTypeListContext?.toList(): List<Pair<String, Type>> {
    return when (this) {
        null -> emptyList()
        else -> listOf(nameType().NAME().text to nameType().type().toType()) + nameTypeList().toList()
    }
}
