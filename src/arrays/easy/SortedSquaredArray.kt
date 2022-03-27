package arrays.easy

import kotlin.math.abs

object SortedSquaredArray {

    @JvmStatic
    fun main(arg: Array<String>) {
        val array = listOf(-10, -5, 0, 5, 10)
        println(sortedSquaredArray(array))
    }

    // O(n) time, O(n) space
    fun sortedSquaredArray(array: List<Int>): List<Int> {
        val output: MutableList<Int> = array.map { 0 }.toMutableList()
        var startIdx = 0
        var endIdx = array.lastIndex

        for (i in array.lastIndex downTo 0) {
            if (abs(array[startIdx]) < abs(array[endIdx])) {
                output[i] = array[endIdx] * array[endIdx]
                endIdx--
            } else {
                output[i] = array[startIdx] * array[startIdx]
                startIdx++
            }
        }

        return output
    }

}

