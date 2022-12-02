package advent_of_code_2022.day2

import kotlin.test.Test
import kotlin.test.assertEquals
import advent_of_code_2022.Days


class MyTest {
    val day = "2"

    @Test
    fun A() {
        assertEquals(
            "11666",
            Days.runCommand(day) {
                it
                    .trim()
                    .replace("X", "A")
                    .replace("Y", "B")
                    .replace("Z", "C")
                    .lines()
                    .map {
                        it
                            .split(" ")
                            .let { (elf, me) ->
                                score(elf, me)
                            }
                    }
                    .sum()
                    .toString()
            },
        )
    }

    @Test
    fun B() {
        assertEquals(
            "12767",
            Days.runCommand(day) {
                it
                    .trim()
                    .lines()
                    .map {
                        it
                            .split(" ")
                            .let { (elf, v) ->
                                elf to mapOf(
                                    "X" to 0,
                                    "Y" to 3,
                                    "Z" to 6,
                                )[v]!!
                            }
                            .let { (elf, sc) ->
                                Fists
                                    .map {
                                        when {
                                            battlePoints(elf, it) == sc -> score(elf, it)
                                            else -> 0
                                        }
                                    }
                                    .sum()
                            }
                    }
                    .sum()
                    .toString()
            },
        )
    }
}


fun score(elf: String, me: String) = fistPoints(me) + battlePoints(elf, me)

fun fistPoints(me: String) = Fists.indexOf(me) + 1

fun battlePoints(elf: String, me: String) = when {
    elf == me -> 3
    (Fists.indexOf(me) - Fists.indexOf(elf) + Fists.size) % Fists.size == 1 -> 6
    else -> 0
}

val Fists = listOf("A", "B", "C")
