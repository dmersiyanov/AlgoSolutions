package algoExpert.arrays

import kotlin.math.abs

object SortedSquaredArray {

    @JvmStatic
    fun main(args: Array<String>) {
        val input = listOf(-3, -2, -1)
        println(sortedSquaredArray(input))
    }

    private fun sortedSquaredArray(array: List<Int>): List<Int> {
        val result = Array(array.size) { 0 }
        var resultIdx = result.lastIndex
        var startIdx = 0
        var endIdx = array.lastIndex

        while (startIdx <= endIdx) {
            val startNum = array[startIdx]
            val endNum = array[endIdx]

            if (abs(startNum) < abs(endNum)) {
                result[resultIdx] = endNum * endNum
                resultIdx--
                endIdx--
            } else {
                result[resultIdx] = startNum * startNum
                resultIdx--
                startIdx++
            }
        }

        return result.toList()
    }
}