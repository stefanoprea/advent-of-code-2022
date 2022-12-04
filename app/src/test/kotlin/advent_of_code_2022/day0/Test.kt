package advent_of_code_2022.day0

import kotlin.test.Test
import kotlin.test.assertEquals
import advent_of_code_2022.Days


class MyTest {
    val day = "0"

    @Test
    fun A() {
        assertEquals(
            "",
            Days.runCommand(day) {
                it
                    .lines()
                    .first()
            },
        )
    }

    @Test
    fun B() {
        assertEquals(
            "",
            Days.runCommand(day) {
                it
                    .lines()
                    .first()
            },
        )
    }
}
