package algoExpert.arrays.medium

import kotlin.math.max

object LongestPeak {

    @JvmStatic
    fun main(args: Array<String>) {
        val array = listOf(1, 2, 3, 3, 4, 0, 10, 6, 5, -1, -3, 2, 3)
        println(longestPeak(array))
    }

    private fun longestPeak(array: List<Int>): Int {
        var result = 0
        var i = 1
        while (i < array.lastIndex) {
            var localResult = 0
            val leftNum = array[i - 1]
            val tipNum = array[i]
            val rightNum = array[i + 1]

            if (leftNum < tipNum && rightNum < tipNum) {
                localResult++

                for (j in i downTo 1) {
                    val num = array[j]
                    if (array[j - 1] < num) {
                        localResult++
                    } else {
                        break
                    }
                }

                var rightIdx = i + 1
                for (k in i..array.lastIndex - 1) {
                    val num = array[k]
                    if (array[k + 1] < num) {
                        localResult++
                        rightIdx = k + 1
                    } else {
                        break
                    }
                }

                result = max(localResult, result)
                i = rightIdx
            } else {
                i++
            }
        }
        return result
    }

}