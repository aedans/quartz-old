package quartz.compiler.tokenizer

/**
 * Created by Aedan Smith.
 */

data class Token(val tokenType: TokenType, val value: String) {
    override fun equals(other: Any?): Boolean {
        return other is Token && other.tokenType == tokenType && other.value == value
    }

    fun equals(tokenType: TokenType): Boolean {
        return tokenType == this.tokenType
    }

    fun equals(tokenType: TokenType, value: String): Boolean {
        return tokenType == this.tokenType && value == this.value
    }

    override fun hashCode(): Int {
        var result = tokenType.hashCode()
        result = 31 * result + value.hashCode()
        return result
    }
}
