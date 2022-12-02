package advent_of_code_2022


val day1A = day1(1)

val day1B = day1(3)

fun day1(noOfElves: Int) = { it: String ->
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