package arrays.medium

import kotlin.math.abs

object SmallestDifference {

    @JvmStatic
    fun main(args: Array<String>) {
        val arrayOne = mutableListOf(0, 20, 1)
        val arrayTwo = mutableListOf(-5)
        println(smallestDifference(arrayOne, arrayTwo))
    }

    fun smallestDifference(arrayOne: MutableList<Int>, arrayTwo: MutableList<Int>): List<Int> {
        arrayOne.sort()
        arrayTwo.sort()
        var output = emptyList<Int>()
        var minDiff = Integer.MAX_VALUE
        var firstArrayIdx = 0
        var secondArrayIdx = 0

        while (firstArrayIdx < arrayOne.size && secondArrayIdx < arrayTwo.size) {
            val firstArrNum = arrayOne[firstArrayIdx]
            val secondArrNum = arrayTwo[secondArrayIdx]
            val currentAbsDiff = abs(firstArrNum - secondArrNum)
            println("current pair = $firstArrNum - $secondArrNum,currentAbsDiff = $currentAbsDiff")

            if (currentAbsDiff < minDiff) {
                minDiff = currentAbsDiff
                output = mutableListOf(firstArrNum, secondArrNum)
            }

            if (firstArrNum < secondArrNum) {
                firstArrayIdx++
            } else {
                secondArrayIdx++
            }
        }

        return output
    }
}