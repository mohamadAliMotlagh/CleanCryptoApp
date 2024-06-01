package com.app.exzi.core.util

import java.text.DecimalFormat
import kotlin.math.min

/**
 * Formats a given number with a specified number of decimal places and thousands separators.
 *
 * @param number The number to be formatted.
 * @param decimalPlaces The number of decimal places to include in the formatted output.
 * @return A string representing the formatted number with thousands separators and the specified number of decimal places.
 *
 * Example usage:
 * ```
 * val formattedNumber1 = formatNumber(1234567.8910, 2)
 * // formattedNumber1 will be "1,234,567.89"
 *
 * val formattedNumber2 = formatNumber(1234567.8910, 0)
 * // formattedNumber2 will be "1,234,567"
 * ```
 *  Unit tests:
 * @see  com.app.exzi.core.util.FormatNumberKtTest
 */

fun formatNumber(number: Double, decimalPlaces: Int = 0): String {

    val formattedString = String.format("%.${if (decimalPlaces < 0) 0 else decimalPlaces}f", number)
    val parts = formattedString.split(".")
    val integerPart = parts[0]

    val decimalPart =
        if (decimalPlaces > 0) {
            parts[1].substring(0, min(decimalPlaces, parts[1].length))
        } else "" // Limit decimals

    val formattedInteger = integerPart.numberSeparator()
    if (decimalPlaces <= 0) return formattedInteger
    return "$formattedInteger.$decimalPart"
}

fun String.decimalNumberSeparator(): String {
    if (!this.contains(".")) return this.numberSeparator()
    val split = this.split(".")
    val integerPart = split[0]
    val decimalPart = split[1]
    return "${integerPart.numberSeparator()}.$decimalPart"
}

fun String.numberSeparator(): String {
    val formatter = DecimalFormat("#,###")
   return formatter.format(this.toDouble())
}
