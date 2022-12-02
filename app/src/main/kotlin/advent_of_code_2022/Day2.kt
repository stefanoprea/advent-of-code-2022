package advent_of_code_2022


val day2A = { it: String ->
    it
        .trim()
        .replace("X", "A")
        .replace("Y", "B")
        .replace("Z", "C")
        .lines()
        .map {
            it
                .split(" ")
                .let {(elf, me) ->
                    score(elf, me)
                }
        }
        .sum()
        .toString()
}

val day2B = { it: String ->
    it
        .trim()
        .lines()
        .map {
            it
                .split(" ")
                .let {(elf, v) ->
                     elf to mapOf(
                        "X" to 0,
                        "Y" to 3,
                        "Z" to 6,
                    )[v] !!
                }
                .let{(elf, sc) ->
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
}

fun score(elf: String, me: String) = fistPoints(me) + battlePoints(elf, me)

fun fistPoints(me: String) = Fists.indexOf(me) + 1

fun battlePoints(elf: String, me: String) = when {
    elf == me -> 3
    (Fists.indexOf(me) - Fists.indexOf(elf) + Fists.size) % Fists.size == 1 -> 6
    else -> 0
}

val Fists = listOf("A", "B", "C")