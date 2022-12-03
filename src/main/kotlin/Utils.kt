fun readLinesFromFile(fileName: String) =
    {}.javaClass.getResourceAsStream(fileName)?.bufferedReader()?.lines()!!