package quartz.compiler.tree.types

import quartz.compiler.tree.Type
import quartz.compiler.tree.util.functionString

/**
 * Created by Aedan Smith.
 */

data class FunctionType(
        val args: List<Type>,
        val returnType: Type,
        val vararg: Boolean
) : Type {
    override fun isConvertibleTo(type: Type): Boolean {
        return type is FunctionType
                && type.vararg == vararg
                && type.returnType.isConvertibleTo(returnType)
                && type.args.size == args.size
                && type.args.zip(args).all { it.first.isConvertibleTo(it.second) }
    }

    override fun toString(): String {
        return functionString(args, returnType, vararg)
    }
}
