import java.util.*

fun day5() {
    val lines = readLinesFromFile("puzzle-5-inputs").toList()!!
    day5Part1(lines, getStacks())
    day5Part2(lines, getStacks())
}

fun day5Part2(lines: List<String>, stacks: ArrayList<ArrayDeque<Char>>) {
    lines.forEach { line ->
        val values = line.split(" ")
        var limit = values[1].toInt()
        val source = stacks[values[3].toInt() - 1]
        val destination = stacks[values.last().toInt() - 1]
        source.toList().subList(0, limit).asReversed().forEach { destination.push(it) }
        while (limit > 0) {
            source.pop()
            limit--
        }
    }
    stacks.forEach { print(it.first) }
}

fun day5Part1(lines: List<String>, stacks: ArrayList<ArrayDeque<Char>>) {
    lines.forEach {
        val values = it.split(" ")
        var repeat = values[1].toInt()
        val source = stacks[values[3].toInt() - 1]
        val destination = stacks[values.last().toInt() - 1]
        while (repeat > 0) {
            destination.push(source.pop())
            repeat--
        }
    }
    stacks.forEach { print(it.first) }
}

/*
            [C]         [N] [R]
[J] [T]     [H]         [P] [L]
[F] [S] [T] [B]         [M] [D]
[C] [L] [J] [Z] [S]     [L] [B]
[N] [Q] [G] [J] [J]     [F] [F] [R]
[D] [V] [B] [L] [B] [Q] [D] [M] [T]
[B] [Z] [Z] [T] [V] [S] [V] [S] [D]
[W] [P] [P] [D] [G] [P] [B] [P] [V]
 1   2   3   4   5   6   7   8   9
*/
private fun getStacks(): ArrayList<ArrayDeque<Char>> {
    return arrayListOf(
        ArrayDeque(listOf('J', 'F', 'C', 'N', 'D', 'B', 'W')),
        ArrayDeque(listOf('T', 'S', 'L', 'Q', 'V', 'Z', 'P')),
        ArrayDeque(listOf('T', 'J', 'G', 'B', 'Z', 'P')),
        ArrayDeque(listOf('C', 'H', 'B', 'Z', 'J', 'L', 'T', 'D')),
        ArrayDeque(listOf('S', 'J', 'B', 'V', 'G')),
        ArrayDeque(listOf('Q', 'S', 'P')),
        ArrayDeque(listOf('N', 'P', 'M', 'L', 'F', 'D', 'V', 'B')),
        ArrayDeque(listOf('R', 'L', 'D', 'B', 'F', 'M', 'S', 'P')),
        ArrayDeque(listOf('R', 'T', 'D', 'V')),
    )
}