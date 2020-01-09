package omni.common.data

/**
 * An amount in cents
 *
 * @property cents
 */
data class Amount(
        val cents: Int
) {

    /**
     * Creates an instance of [Amount] representing the given dollar value
     */
    constructor(dollars: Float) : this(dollars.times(100).toInt())

    /**
     * Creates an instance of [Amount] representing the given dollar value
     */
    constructor(dollars: Double) : this(dollars.times(100).toInt())

    /**
     * Creates an instance of [Amount] representing the given dollar value
     */
    constructor(dollars: Number) : this(dollars.toFloat().times(100).toInt())

    /**
     * @return a string that shows how many cents this Amount represents
     */
    fun centsString() = cents.toString()

    /**
     * Creates a string representing the number of dollars that this Amount represents
     *
     * Example: An Amount representing ten dollars would return "10.00"
     *
     * @return a string representing the number of dollars that this Amount represents
     *
     */
    fun dollarsString(): String {
        var numString = (cents / 100.0).toString()

        // If number is negative, remove the negative and add at the end
        var sign = ""
        if (numString.first() == '-') {
            sign = "-"
            numString = numString.substring(1)
        }

        // Split the string in two parts, dollars and cents
        val split = numString.split(".")

        // Get dollars
        val dollars = split.first()

        // Get 2 places of cents
        val cents = if (split.size > 1) {
            val c = split[1]

            when {
                c.length >= 2 -> {
                    c.substring(0, 2)
                }
                c.isNotEmpty() -> {
                    c[0] + "0"
                }
                else -> {
                    "00"
                }
            }
        } else {
            "00"
        }

        return "$sign$dollars.$cents"
    }

    /**
     * @return the amount in dollars
     */
    fun dollars() = dollarsString().toDouble()

    /**
     * Creates a pretty string to represent the amount in dollars
     *
     * Example: ten dollars and eighty-three cents would return "$10.83"
     *
     */
    fun pretty() = "\$${dollarsString()}"
}