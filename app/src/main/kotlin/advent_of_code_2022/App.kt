/*
 * This Kotlin source file was generated by the Gradle 'init' task.
 */
package advent_of_code_2022

import kotlinx.coroutines.runBlocking
import java.io.File
import io.ktor.client.HttpClient
import io.ktor.client.engine.cio.CIO
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*


fun getEnvVar(key: String) = System.getenv(key) ?: exitWithMessage("Please set env var $key")

fun exitWithMessage(message: String) : Nothing {
    println(message)
    kotlin.system.exitProcess(1)
}

class Days {
    companion object :  HashMap<String, (String) -> String>() {

        fun runCommand(key: String): String {
            val command = this.get(key) ?: exitWithMessage("Days must be one of: ${this.keys.joinToString()}")
            val filename = makeFilename(key)
            val input = readInput(filename)
            return command(input)
        }

        private fun makeFilename(key: String) = "[^0-9]+$".toRegex().replace(key, "")

        private fun readInput(name: String) = inputFile(name).readText()

        private fun inputFile(name: String) = File("src/input", "$name.txt")

        fun register(key: String, value: (String) -> String) = apply {
            if (this.containsKey(key)) {
                return exitWithMessage("Duplicate key $key")
            }
            this[key] = value
            downloadInput(key)
        }

        private fun downloadInput(key: String) {
            val filename = makeFilename(key)
            if (inputFile(filename).exists()) {
                return
            }
            val input = fetchInput(filename)
            inputFile(filename).writeText(input)
        }

        private fun fetchInput(filename: String) = HttpClient(CIO).use { client ->
            runBlocking {
                val response = client.get("https://adventofcode.com/2022/day/$filename/input") {
                    header("Cookie", readCookie())
                }
                when (response.status.isSuccess()) {
                    false -> exitWithMessage("Couldn't fetch input from server. Day: $filename Response: $response")
                    true -> response.bodyAsText()
                }
            }
        }

        private fun readCookie() = File("src/cookie", "cookie.txt")
            .readText()

        init {
            Days
                .register("1A", day1A)
                .register("1B", day1B)
                .register("2A", day2A)
                .register("2B", day2B)
                .register("3A", day3A)
                .register("3B", day3B)
        }
    }
}

fun main() {
    val day = getEnvVar("DAY")
    println(Days.runCommand(day))
}