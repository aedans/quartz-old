package quartz.compiler.errors

import org.antlr.v4.runtime.ANTLRErrorListener
import org.antlr.v4.runtime.Parser
import org.antlr.v4.runtime.RecognitionException
import org.antlr.v4.runtime.Recognizer
import org.antlr.v4.runtime.atn.ATNConfigSet
import org.antlr.v4.runtime.dfa.DFA
import java.util.*

/**
 * Created by Aedan Smith.
 */

class ErrorListener : ANTLRErrorListener {
    override fun syntaxError(parser: Recognizer<*, *>?, p1: Any?, line: Int, char: Int, message: String?, e: RecognitionException?) {
        throw QuartzException("line $line:$char $message", emptyList())
    }

    override fun reportAmbiguity(p0: Parser?, p1: DFA?, p2: Int, p3: Int, p4: Boolean, p5: BitSet?, p6: ATNConfigSet?) {
//        println("Ambiguity!")
    }

    override fun reportAttemptingFullContext(p0: Parser?, p1: DFA?, p2: Int, p3: Int, p4: BitSet?, p5: ATNConfigSet?) {

    }

    override fun reportContextSensitivity(p0: Parser?, p1: DFA?, p2: Int, p3: Int, p4: Int, p5: ATNConfigSet?) {

    }
}
