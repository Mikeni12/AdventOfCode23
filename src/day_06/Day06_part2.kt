package day_06

import println
import readInput

fun main() {

    fun String.getQuantity() = fold("") { acc, c: Char ->
        acc.plus(c.takeIf { it.isDigit() } ?: "")
    }.toLong()

    fun part2(input: List<String>): Int {
        val time = input.first().getQuantity()
        val distance = input.last().getQuantity()
        val winning = (0..time).mapIndexedNotNull { timeIndex, _ ->
            (1 * timeIndex * (time - timeIndex)).takeIf { it > distance }
        }
        return winning.size
    }

    val testInput = readInput("day_06/Input_test")
    check(part2(testInput) == 71503)

    val input = readInput("day_06/Input")
    part2(input).println()
}
