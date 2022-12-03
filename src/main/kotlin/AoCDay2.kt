fun day2() {
    day2Part1()
    day2Part2()
}

private fun day2Part2() {
    val lines = readLinesFromFile("puzzle-2-inputs")
    var score = 0
    val map = mapOf(
        "A Y" to 4,
        "B Y" to 5,
        "C Y" to 6,
        "A X" to 3,
        "B X" to 1,
        "C X" to 2,
        "A Z" to 8,
        "B Z" to 9,
        "C Z" to 7
    )
    lines.forEach {
        score += map[it]!!
    }
    println(score)
}

private fun day2Part1() {
    val lines = readLinesFromFile("puzzle-2-inputs")
    var score = 0
    val map = mapOf('A' to 1, 'X' to 1, 'B' to 2, 'Y' to 2, 'C' to 3, 'Z' to 3)
    lines.forEach {
        score += when (it) {
            "A Y", "B Z", "C X" -> map[it.last()]!! + 6
            "A X", "B Y", "C Z" -> map[it.last()]!! + 3
            else -> map[it.last()]!!
        }
    }
    println(score)
}