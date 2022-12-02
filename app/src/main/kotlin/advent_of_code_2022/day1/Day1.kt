package advent_of_code_2022.day1

import advent_of_code_2022.Days
import advent_of_code_2022.calculate


val day1A = { day1(1) }

val day1B = { day1(3) }

fun day1(noOfElves: Int) = calculate(inputDay1) {
    it.trim()
        .split("\n\n")
        .map {
            it.split("\n")
                .map { it.toInt() }
                .sum()
        }
        .sortedDescending()
        .take(noOfElves)
        .sum()
        .toString()
}