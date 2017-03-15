package quartz.compiler.syntax.type.types

import quartz.compiler.util.Type

/**
 * Created by Aedan Smith.
 */

object Primitives {
    val char: Type = QChar()
    val short: Type = QShort()
    val int: Type = QInt()
    val long: Type = QLong()
    val float: Type = QFloat()
    val double: Type = QDouble()
    val void: Type = QVoid()
}

private open class NumType : Type {
    override fun canCastTo(type: Type): Boolean {
        return type is NumType
    }
}

private class QChar : NumType() {
    override fun toString(): String {
        return "char"
    }
}

private class QShort : NumType() {
    override fun toString(): String {
        return "short"
    }
}

private class QInt : NumType() {
    override fun toString(): String {
        return "int"
    }
}

private class QLong : NumType() {
    override fun toString(): String {
        return "long"
    }
}

private class QFloat : NumType() {
    override fun toString(): String {
        return "float"
    }
}

private class QDouble : NumType() {
    override fun toString(): String {
        return "double"
    }
}

private class QVoid : Type {
    override fun canCastTo(type: Type): Boolean {
        return true
    }

    override fun toString(): String {
        return "void"
    }
}