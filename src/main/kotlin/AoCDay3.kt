fun day3() {
    day3Part1()
    day3Part2()
}

private data class RuckSack(val compartment1: String, val compartment2: String) {
    fun getCommonItem(): Char? {
        val chars1 = compartment1.toCharArray()
        val chars2 = compartment2.toCharArray()
        for (i in chars1) {
            if (chars2.contains(i)) {
                return i
            }
        }
        return null
    }
}

private fun getPrioritiesMap(): Map<Char, Int> {
    val priorities = mutableMapOf<Char, Int>()
    var baseChar = 'a'
    for (i in 1 until 27) {
        priorities[baseChar] = i
        baseChar++
    }
    baseChar = 'A'
    for (i in 27 until 53) {
        priorities[baseChar] = i
        baseChar++
    }
    return priorities
}



private fun getRuckSacks(): MutableList<RuckSack> {
    val lines = readLinesFromFile("puzzle-3-inputs")
    val ruckSacks = mutableListOf<RuckSack>()
    lines.forEach {
        ruckSacks.add(RuckSack(it.substring(0, it.length / 2), it.substring(it.length / 2)))
    }
    return ruckSacks
}

private fun getCommonChar(triple: Triple<String, String, String>): Char? {
    val set1 = triple.first.toSet()
    val set2 = triple.second.toSet()
    val set3 = triple.third.toSet()
    set1.forEach {
        if (set2.contains(it) && set3.contains(it)) {
            return it
        }
    }
    return null
}

private fun day3Part2() {
    val priorities = getPrioritiesMap()
    val lines = readLinesFromFile("puzzle-3-inputs").toList().windowed(3, 3)
    var sum = 0
    lines.forEach{
        sum+=priorities[getCommonChar(Triple(it[0],it[1],it[2]))]!!
    }
    println(sum)
}

private fun day3Part1() {
    val priorities = getPrioritiesMap()
    val ruckSacks = getRuckSacks()
    var sum = 0
    for (i in ruckSacks) {
        if (priorities[i.getCommonItem()] != null) {
            sum += priorities[i.getCommonItem()]!!
        }
    }
    println(sum)
}
