package arrays.hard

object ZigzagTraverse {

    @JvmStatic
    fun main(args: Array<String>) {
        val array = listOf(
            listOf(1, 3, 4, 7, 8),
            listOf(2, 5, 6, 9, 10),

            )

        val array2 = listOf(
            listOf(1, 2, 3, 4, 5)
        )

        val array3 = listOf(
            listOf(1, 3, 4, 10),
            listOf(2, 5, 9, 11),
            listOf(6, 8, 12, 15),
            listOf(7, 13, 14, 16)
        )
        println(zigzagTraverse(array2))
    }

    fun zigzagTraverse(array: List<List<Int>>): List<Int> {
        var directionDown = true
        val output = mutableListOf<Int>()
        var row = 0
        var column = 0
        val width = array.first().lastIndex
        val height = array.lastIndex

        while (isInBounds(array, row, column)) {
            val currentNum = array[row][column]
            output.add(currentNum)

            // идем вниз
            if (directionDown) {
                if (column == 0 || row == height) {
                    directionDown = false
                    if (row == height) {
                        column++
                    } else {
                        row++
                    }
                } else {
                    row++
                    column--
                }

            } else {
                // идем вверх
                if (column == width || row == 0) {
                    directionDown = true
                    if (column == width) {
                        row++
                    } else {
                        column++
                    }
                } else {
                    column++
                    row--
                }
            }
        }
        return output
    }

    private fun isInBounds(array: List<List<Int>>, row: Int, column: Int): Boolean {
        return row < array.size && row >= 0 && column < array.first().size && column >= 0
    }

}