package day_02

import println
import readInput

fun main() {

    fun Regex.findMax(line: String) = findAll(line).map { it.destructured.component1().toInt() }.max()

    fun part2(input: List<String>) = input.sumOf { line: String ->
        val red = """(\d+) r""".toRegex().findMax(line)
        val green = """(\d+) g""".toRegex().findMax(line)
        val blue = """(\d+) b""".toRegex().findMax(line)
        red.times(green).times(blue)
    }

    val testInput = readInput("day_02/Input_test")
    check(part2(testInput) == 2286)

    val input = readInput("day_02/Input")
    part2(input).println()
}
