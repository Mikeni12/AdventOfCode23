package day_02

import println
import readInput

fun main() {

    fun Regex.findAllMatches(line: String) = findAll(line).map { it.destructured.component1().toInt() }

    fun part1(input: List<String>) = input.sumOf { line ->
        val gameId = """Game (\d+):""".toRegex().find(line)?.destructured?.component1()?.toIntOrNull() ?: 0
        val isRedPossible = """(\d+) r""".toRegex().findAllMatches(line).none { it > 12 }
        val isGreenPossible = """(\d+) g""".toRegex().findAllMatches(line).none { it > 13 }
        val isBluePossible = """(\d+) b""".toRegex().findAllMatches(line).none { it > 14 }
        gameId.takeIf { isRedPossible && isGreenPossible && isBluePossible } ?: 0
    }

    val testInput = readInput("day_02/Input_test")
    check(part1(testInput) == 8)

    val input = readInput("day_02/Input")
    part1(input).println()
}
