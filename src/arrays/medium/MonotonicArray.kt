package arrays.medium

// https://www.algoexpert.io/questions/Monotonic%20Array
object MonotonicArray {

    @JvmStatic
    fun main(args: Array<String>) {
        val array = listOf<Int>(1, 1, 2, 3, 4, 5, 5, 5, 6, 7, 8, 7, 9, 10, 11)
        println(isMonotonic(array))
    }

    fun isMonotonic(array: List<Int>): Boolean {
        if (array.isEmpty() || array.size == 1) {
            return true
        }

        var increasing: Boolean? = null

        for (i in 0..(array.size - 2)) {
            val curNum = array[i]
            val nextNum = array[i + 1]

            if (increasing == null) {
                if (curNum > nextNum) {
                    increasing = false
                } else if (curNum < nextNum) {
                    increasing = true
                }
            } else {
                if (curNum != nextNum) {
                    if (increasing != curNum < nextNum ) {
                        return false
                    }
                }
            }
        }
        return true
    }

    fun isMonotonic2(array: List<Int>): Boolean {

        var nonDecrising = true
        var nonIncreasing = true

        for(i in 0..(array.size - 2)) {
            val current = array[i]
            val next = array[i + 1]

            if(current < next) {
                nonIncreasing = false
            } else if(current > next) {
                nonDecrising = false
            }

        }

        return nonIncreasing || nonDecrising
    }
}