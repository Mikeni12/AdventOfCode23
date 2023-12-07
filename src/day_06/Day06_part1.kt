package day_06

import println
import readInput

fun main() {

    fun String.getQuantities() = split(" ").mapNotNull { it.toIntOrNull() }

    fun part1(input: List<String>): Int {
        val times = input.first().getQuantities()
        val distances = input.last().getQuantities()
        val timeToDistanceMap = times.indices.map { times[it] to distances[it] }
        return timeToDistanceMap.fold(1) { acc, timeToDistance ->
            val (time, distance) = timeToDistance
            val winning = (0..time).mapIndexedNotNull { timeIndex, _ ->
                (1 * timeIndex * (time - timeIndex)).takeIf { it > distance }
            }
            acc * winning.size
        }
    }

    val testInput = readInput("day_06/Input_test")
    check(part1(testInput) == 288)

    val input = readInput("day_06/Input")
    part1(input).println()
}
