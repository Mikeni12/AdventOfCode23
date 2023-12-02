package day_01

import println
import readInput

fun main() {

    val numbersMapped = listOf("one", "two", "three", "four", "five", "six", "seven", "eight", "nine")
        .mapIndexed { index, number ->
            index.plus(1).toString() to number
        }

    val numbersList = numbersMapped.flatMap { listOf(it.first, it.second) }

    fun firstMatch(stringNumber: String) = numbersMapped.firstOrNull { it.second == stringNumber }?.first?.toIntOrNull()

    fun part2(input: List<String>) = input.sumOf { line: String ->
        val firstDigit = line.findAnyOf(numbersList)?.second?.let { firstMatch(it) ?: it.toInt() } ?: 0
        val lastDigit = line.findLastAnyOf(numbersList)?.second?.let { firstMatch(it) ?: it.toInt() } ?: 0
        firstDigit.times(10) + lastDigit
    }

    val testInput = readInput("day_01/Input_test_part_2")
    check(part2(testInput) == 281)

    val input = readInput("day_01/Input")
    part2(input).println()
}
