package day_01

import println
import readInput

fun main() {
    fun part1(input: List<String>) = input.sumOf { line ->
        val digits = line.mapNotNull { it.digitToIntOrNull() }
        digits.first().times(10) + digits.last()
    }

    val testInput = readInput("day_01/Input_test_part_1")
    check(part1(testInput) == 142)

    val input = readInput("day_01/Input")
    part1(input).println()
}
