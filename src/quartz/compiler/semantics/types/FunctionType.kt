package quartz.compiler.semantics.types

import quartz.compiler.util.Function
import quartz.compiler.util.Type

/**
 * Created by Aedan Smith.
 */

data class FunctionType(val function: Function) : Type("$function") {
    override fun mapTypes(function: (Type?) -> Type?): Type {
        return FunctionType(this.function.mapTypes(function))
    }

    override fun canCastTo(type: Type): Boolean {
        return type == this
    }
}
