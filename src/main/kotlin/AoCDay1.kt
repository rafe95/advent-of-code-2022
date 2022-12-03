fun day1() {
    val lines = readLinesFromFile("puzzle-1-inputs")
    val sums = mutableListOf<Int>()
    var sum = 0
    lines.forEach {
        if (it.isNotBlank()) sum += it.toInt() else {
            sums.add(sum)
            sum = 0
        }
    }
    sums.sort()
    println(sums[sums.size - 1]) //part 1 get the highest value
    println(sums[sums.size - 1] + sums[sums.size - 2] + sums[sums.size - 3]) //part 2 get the sum of the three highest values
}