fun day4() {
    val lines = readLinesFromFile("puzzle-4-inputs").toList()!!
    var overlapped = 0
    var full = 0
    lines.forEach count@{
        val nums = it.split(",")
        val pair1 = nums[0].split("-")
        val pair2 = nums[1].split("-")
        val range1 = IntRange(pair1[0].toInt(), pair1[1].toInt())
        val range2 = IntRange(pair2[0].toInt(), pair2[1].toInt())
        if (isFullyOverlapped(range1, range2)) {
            full++
        }
        if (range1.contains(range2.first) || range1.contains(range2.last)) {
            overlapped++
            return@count
        }
        if (range2.contains(range1.first) || range2.contains(range1.last)) {
            overlapped++
            return@count
        }
    }
    println(full)
    println(overlapped)
}

fun isFullyOverlapped(range1: IntRange, range2: IntRange): Boolean =
    (range1.contains(range2.first) && range1.contains(range2.last)) || (range2.contains(range1.first) && range2.contains(
        range1.last
    ))