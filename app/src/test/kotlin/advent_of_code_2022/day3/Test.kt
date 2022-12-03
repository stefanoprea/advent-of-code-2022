package advent_of_code_2022.day3

import kotlin.test.Test
import kotlin.test.assertEquals
import advent_of_code_2022.Days


class MyTest {
    val day = "3"

    @Test
    fun A() {
        assertEquals(
            "7793",
            Days.runCommand(day) {
                it
                    .trim()
                    .split("\n")
                    .map { it.chunked(it.length / 2) }
                    .solve()
            },
        )
    }

    @Test
    fun B() {
        assertEquals(
            "2499",
            Days.runCommand(day) {
                it
                    .trim()
                    .split("\n")
                    .chunked(3)
                    .solve()
            },
        )
    }

    private fun (List<List<String>>).solve() = this
        .map {
            it
                .map { it.toSet() }
                .reduce { a, b -> a.intersect(b) }
                .first()
        }
        .map {
            when (val c = it.code) {
                in 'a'.code .. 'z'.code -> c - 'a'.code + 1
                in 'A'.code .. 'Z'.code -> c - 'A'.code + 27
                else -> throw Exception("Bad char $it")
            }
        }
        .sum()
        .toString()
}
