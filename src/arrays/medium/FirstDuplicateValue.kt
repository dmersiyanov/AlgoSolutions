package arrays.medium

import kotlin.math.abs

object FirstDuplicateValue {
    @JvmStatic
    fun main(args: Array<String>) {
        println(firstDuplicateValue(arrayListOf(2, 1, 5, 2, 3, 3, 4)))
    }

    fun firstDuplicateValue(array: MutableList<Int>): Int {
        array.forEachIndexed { index, number ->
            if (array[abs(number) - 1] <= 0) {
                return abs(number)
            } else {
                array[abs(number) - 1] *= -1
            }
        }
        return -1
    }
}