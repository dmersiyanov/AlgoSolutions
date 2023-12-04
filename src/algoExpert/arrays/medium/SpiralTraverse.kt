package algoExpert.arrays.medium

object SpiralTraverse {

    @JvmStatic
    fun main(args: Array<String>) {
        val matrix = listOf(
            listOf(1, 3, 2, 5, 4, 7, 6),
//            listOf(1, 2, 3),
//            listOf(8, 9, 4),
//            listOf(7, 6, 5)
        )
        println(spiralTraverse(matrix))
    }

    private fun spiralTraverse(array: List<List<Int>>): List<Int> {

        val result = mutableListOf<Int>()

        var rowStartIdx = 0
        var rowEndIdx = array.lastIndex
        var colStartIdx = 0
        var colEndIdx = array[0].lastIndex

        while (rowStartIdx <= rowEndIdx && colStartIdx <= colEndIdx) {

            for (col in colStartIdx..colEndIdx) {
                result.add(array[rowStartIdx][col])
            }

            for (row in rowStartIdx + 1..rowEndIdx) {
                result.add(array[row][colEndIdx])
            }

            if (rowStartIdx == rowEndIdx || colStartIdx == colEndIdx) {
                break
            }

            for (col in colEndIdx - 1 downTo colStartIdx) {
                result.add(array[rowEndIdx][col])
            }

            for (row in rowEndIdx - 1 downTo rowStartIdx + 1) {
                result.add(array[row][colStartIdx])
            }

            rowStartIdx++
            rowEndIdx--
            colStartIdx++
            colEndIdx--

        }

        return result
    }


}