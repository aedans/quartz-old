package quartz.compiler.cli

import com.xenomachina.argparser.HelpFormatter
import quartz.compiler.util.times

/**
 * Created by Aedan Smith.
 */

class QuartzHelpFormatter : HelpFormatter {
    override fun format(progName: String?, columns: Int, values: List<HelpFormatter.Value>): String {
        var string = ""
        string += "usage: "
        values.forEach { string += if (it.isRequired) "${it.usages[0]} " else "[${it.usages[0]}] " }
        string += "\n\narguments:\n"
        val longest = values.map { it.usages.joinToString().length }.max() ?: 0
        values.forEach {
            string += "  ${it.usages.joinToString()}"
            string += " " * (longest - it.usages.joinToString().length + 2)
            string += "${it.help}\n"
        }
        return string
    }
}
