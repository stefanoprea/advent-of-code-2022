package advent_of_code_2022


interface Common : () -> Unit {
    abstract fun getInput() : String
    abstract fun run(input: String) : String
    override operator fun invoke() = println(run(getInput()))
}