package advent_of_code_2022.day1

import advent_of_code_2022.Common


val A = object : Day1Interface {
    override fun run(input: String) = calculateElvesCalories(input)
        .maxOrNull() !!
        .toString()
}

val B = object : Day1Interface {
    override fun run(input: String) = calculateElvesCalories(input)
        .sortedDescending()
        .slice(0 until 3)
        .sum()
        .toString()
}

interface Day1Interface : Common {
    override fun getInput() = input

    fun calculateElvesCalories(input: String) = input
        .split("\n\n")
        .map {
            it.split("\n")
                .map { it.trim() }
                .filter { !it.isEmpty() }
                .map { it.toInt() }
                .sum()
        }
        .also {
            if (it.size == 0) {
                throw Exception("Elves list is empty")
            }
        }
}