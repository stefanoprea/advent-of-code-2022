package advent_of_code_2022.day4

import kotlin.test.Test
import kotlin.test.assertEquals
import advent_of_code_2022.Days


class MyTest {
    val day = "4"

    @Test
    fun A() {
        assertEquals(
            "644",
            Days.runCommand(day, solve { a, b ->
                a.start in b && a.endInclusive in b ||
                        b.start in a && b.endInclusive in a
            })
        )
    }

    @Test
    fun B() {
        assertEquals(
            "926",
            Days.runCommand(day, solve { a, b ->
                a.start <= b.endInclusive && b.start <= a.endInclusive
            })
        )
    }

    private fun solve(check: (a: IntRange, b: IntRange) -> Boolean) = { it: String ->
        it
            .trim()
            .lines()
            .map {
                it
                    .split(",")
                    .map {
                        it
                            .split("-")
                            .map { it.toInt() }
                            .let { (x, y) -> x..y }
                    }
                    .let { (a, b) -> check(a, b) }
                    .let { if (it) 1 else 0 }
            }
            .sum()
            .toString()
    }
}
