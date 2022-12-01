package advent_of_code_2022


interface Common : () -> Unit {
    override operator fun invoke() = println(calculateResult())

    fun calculateResult() = run(getInput())

    abstract fun run(input: String) : String


    abstract fun getInput() : String
}