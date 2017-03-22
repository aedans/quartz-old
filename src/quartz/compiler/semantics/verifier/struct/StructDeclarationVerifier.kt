package quartz.compiler.semantics.verifier.struct

import quartz.compiler.syntax.tree.program.function.FnDeclarationNode
import quartz.compiler.syntax.tree.program.function.statement.ReturnNode
import quartz.compiler.syntax.tree.program.misc.InlineCNode
import quartz.compiler.syntax.tree.program.struct.StructDeclarationNode

/**
 * Created by Aedan Smith.
 */

val StructDeclarationNode.defaultConstructor: FnDeclarationNode
    get() {
        val defaultConstructor = FnDeclarationNode(name, members.map { it.name to it.type }, type)
        var s = "(struct $type) {"
        defaultConstructor.args.dropLast(1).forEach { s += it.first + ", " }
        s += defaultConstructor.args.last().first + "}"
        defaultConstructor.statements.add(ReturnNode(InlineCNode(s).apply { type = this@defaultConstructor.type }))
        return defaultConstructor
    }
