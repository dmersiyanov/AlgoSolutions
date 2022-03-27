package arrays.hard

import kotlin.math.max
import kotlin.math.min

object SubArraySort {

    @JvmStatic
    fun main(args: Array<String>) {
        val array = listOf<Int>(2, 1)
        println(subarraySort(array))
    }

    fun subarraySort(array: List<Int>): List<Int> {
        var min = Int.MAX_VALUE
        var max = Int.MIN_VALUE

        for (i in array.indices) {
            val current = array[i]
            if (isOutOfOrder(i, current, array)) {
                min = min(current, min)
                max = max(current, max)
            }
        }

        return mutableListOf(findMinPosition(array, min), findMaxPosition(array, max))
    }

    private fun isOutOfOrder(idx: Int, number: Int, array: List<Int>): Boolean {
        return when (idx) {
            0 -> number > array[idx + 1]
            array.lastIndex -> number < array[idx - 1]
            else -> number > array[idx + 1] || number < array[idx-1]
        }
    }

    private fun findMaxPosition(array: List<Int>, number: Int): Int {
        for (i in array.lastIndex downTo 0) {
            if (array[i] <= number) {
                return i
            }
        }
        return -1
    }

    private fun findMinPosition(array: List<Int>, number: Int): Int {
        for (i in array.indices) {
            if (array[i] > number) {
                return i
            }
        }
        return -1
    }
}