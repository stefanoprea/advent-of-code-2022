package advent_of_code_2022.day1

import kotlin.test.Test
import kotlin.test.assertEquals
import advent_of_code_2022.Days


class MyTest {
    val day = "1"

    @Test
    fun A() {
        assertEquals(
            "67016",
            Days.runCommand(day, solve(1))
        )
    }

    @Test
    fun B() {
        assertEquals(
            "200116",
            Days.runCommand(day, solve(3)),
        )
    }
}


fun solve(noOfElves: Int) = { it: String ->
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
