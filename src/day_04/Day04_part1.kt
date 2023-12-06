package day_04

import println
import readInput

fun main() {

    fun String.getNumbers() = split(" ").mapNotNull { it.toIntOrNull() }

    fun part1(input: List<String>) = input.sumOf { line ->
        val (winningNumbersString, numbersString) = line.split("|")
        val winningNumbers = winningNumbersString.split(":").last().getNumbers()
        val numbers = numbersString.getNumbers()
        val worthPoints = numbers.fold(0) { acc, number ->
            winningNumbers.firstOrNull { number == it }?.let { if (acc == 0) 1 else acc * 2 } ?: acc
        }
        worthPoints
    }

    val testInput = readInput("day_04/Input_test")
    check(part1(testInput) == 13)

    val input = readInput("day_04/Input")
    part1(input).println()
}
