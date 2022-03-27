package arrays.medium

import kotlin.math.max

object LongestPeak {

    @JvmStatic
    fun main(args: Array<String>) {
        val array = listOf<Int>(1, 2, 3, 3, 4, 0, 10, 6, 5, -1, -3, 2, 3)
        println(longestPeak(array))
    }

    fun longestPeak(array: List<Int>): Int {
        var longestPeak = 0
        var i = 1
        while (i < array.lastIndex) {
            val leftNum = array[i - 1]
            val potentialPeak = array[i]
            val rightNum = array[i + 1]

            if (potentialPeak > leftNum && potentialPeak > rightNum) {
                var leftIdx = i - 2
                var rightIdx = i + 2

                while (leftIdx >= 0 && array[leftIdx] < array[leftIdx + 1]) {
                    leftIdx--
                }

                while (rightIdx < array.size && array[rightIdx] < array[rightIdx - 1]) {
                    rightIdx++
                }

                val currentPeak = rightIdx - leftIdx - 1
                longestPeak = max(currentPeak, longestPeak)
                i = rightIdx
            } else {
                i++
            }
        }

        return longestPeak
    }

    fun longestPeak2(array: List<Int>): Int {
        var longestPeak = 0

        var i = 1
        while(i < array.lastIndex) {

            if(array[i-1] < array[i] && array[i] > array[i+1]){
                var leftIdx = i-2
                var rightIdx = i+2

                while(leftIdx >= 0 && array[leftIdx] < array[leftIdx + 1]) {
                    leftIdx++
                }

                while(rightIdx < array.size && array[rightIdx] < array[rightIdx - 1]) {
                    rightIdx++
                }

                val current = rightIdx - leftIdx - 1

                longestPeak = max(longestPeak, current)

                i = rightIdx

            } else {
                i++
            }
        }


        return longestPeak
    }
}

