package day_04

import println
import readInput

fun main() {

    data class ScratchCard(val winningNumbers: List<Int>, val numbers: List<Int>, var copies: Int = 1)

    fun String.getNumbers() = split(" ").mapNotNull { it.toIntOrNull() }

    fun part2(input: List<String>): Int {
        val scratchCards = input.map { line ->
            val (winningNumbersString, numbersString) = line.split("|")
            val winningNumbers = winningNumbersString.split(":").last().getNumbers()
            val numbers = numbersString.getNumbers()
            ScratchCard(winningNumbers, numbers)
        }
        scratchCards.forEachIndexed { index, scratchCard ->
            scratchCard.numbers.fold(0) { acc, number ->
                scratchCard.winningNumbers.firstOrNull { number == it }?.let { acc + 1 } ?: acc
            }.also { nextCardsIndexes ->
                repeat(nextCardsIndexes) {
                    scratchCards[index + 1 + it].copies += 1 * scratchCard.copies
                }
            }
        }
        return scratchCards.sumOf { it.copies }
    }

    val testInput = readInput("day_04/Input_test")
    check(part2(testInput) == 30)

    val input = readInput("day_04/Input")
    part2(input).println()
}
