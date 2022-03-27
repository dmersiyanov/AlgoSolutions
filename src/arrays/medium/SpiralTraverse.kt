package arrays.medium

object SpiralTraverse {
    @JvmStatic
    fun main(args: Array<String>) {
        val matrix = listOf(
            listOf(4, 2, 3, 6, 7, 8, 1, 9, 5, 10),
            listOf(12, 19, 15, 16, 20, 18, 13, 17, 11, 14),
        )
        println(spiralTraverse(matrix))
    }

    fun spiralTraverse(array: List<List<Int>>): List<Int> {
        val output = mutableListOf<Int>()

        var startRow = 0
        var endRow = array.size - 1

        var startColumn = 0
        var endColumn = array.first().size - 1

        while (startRow <= endRow && startColumn <= endColumn) {

            for (i in startColumn..endColumn) {
                output.add(array[startRow][i])
            }

            for (i in startRow + 1 ..endRow  ) {
                output.add(array[i][endColumn])
            }

            for (i in endColumn - 1 downTo startColumn) {
                if (startRow == endRow) break
                output.add(array[endRow][i])
            }

            for (i in endRow - 1 downTo startRow + 1) {
                if (startColumn == endColumn) break
                output.add(array[i][startColumn])
            }

            startRow++
            startColumn++
            endColumn--
            endRow--

        }

        return output
    }

    fun spiralTraverse2(array: List<List<Int>>): List<Int> {
        val output = mutableListOf<Int>()

        var startCol = 0
        var endCol = array.first().size - 1

        var startRow = 0
        var endRow = array.size - 1

        while(startCol <= endCol || startRow <= endRow) {

            for(col in startCol..endCol) {
                output.add(array[startRow][col])
            }

            for(row in startRow + 1..endRow) {
                output.add(array[row][endCol])
            }

            for(col in endCol-1 downTo startCol){
                output.add(array[endRow][col])
            }

            for(row in endRow - 1 downTo startCol + 1) {
                output.add(array[row][startCol])
            }

            startCol++
            startRow++
            endCol--
            endRow--

        }

        return output
    }

}