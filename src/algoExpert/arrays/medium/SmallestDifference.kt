package algoExpert.arrays.medium

import kotlin.math.abs

object SmallestDifference {

    @JvmStatic
    fun main(args: Array<String>) {
        val arrayOne = mutableListOf(-1, 5, 10, 20, 28, 3)
        val arrayTwo = mutableListOf(26, 134, 135, 15, 17)
        println(smallestDifference(arrayOne, arrayTwo))
    }

    fun smallestDifference(arrayOne: MutableList<Int>, arrayTwo: MutableList<Int>): List<Int> {
        val result = mutableListOf(0, 0)
        var smallestDiff = Int.MAX_VALUE

        arrayOne.sort()
        arrayTwo.sort()

        var firstIdx = 0
        var secondIdx = 0

        while (firstIdx < arrayOne.size && secondIdx < arrayTwo.size) {
            val firstNum = arrayOne[firstIdx]
            val secondNum = arrayTwo[secondIdx]

            val checkDiff = abs(firstNum - secondNum)

            if (checkDiff < smallestDiff) {
                result[0] = firstNum
                result[1] = secondNum
                smallestDiff = checkDiff
            }

            if (checkDiff == 0) {
                return result
            } else {
                if (firstNum < secondNum) {
                    firstIdx++
                } else {
                    secondIdx++
                }
            }
        }

        return result
    }
}