fun day6() {
    val packet = readLinesFromFile("puzzle-6-inputs").toList()[0].toString()

    countCharactersBefore(packet,4) // part 1
    countCharactersBefore(packet,14) // part 2

}
private fun countCharactersBefore(packet:String, nth:Int){
    for (i in packet.indices) {
        val limit = if (i + nth >= packet.length) packet.length else i + nth
        val s = packet.substring(i, limit)
        if (s.toSet().size == nth) {
            println(limit)
            break
        }
    }
}
