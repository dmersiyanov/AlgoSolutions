package arrays.medium

object MoveElementToEnd {
    @JvmStatic
    fun main(args: Array<String>) {
        val array = mutableListOf(2, 1, 2, 2, 2, 3, 4, 2)
//        val array = mutableListOf(2, 1, 3)
        val toMove = 2
        println(moveElementToEnd(array, toMove))
    }

    // O(n) time, O(1) space
    private fun moveElementToEnd(array: MutableList<Int>, toMove: Int): List<Int> {
        var left = 0
        var right = array.lastIndex

        while (left < right) {
            val leftNum = array[left]
            val rightNum = array[right]

            if (leftNum == toMove) {
                if (rightNum != toMove) {
                    swap(right, left, array)
                }
                right--
            } else {
                left++
            }
        }
        return array
    }

    private fun swap(indexTo: Int, indexFrom: Int, array: MutableList<Int>) {
        val old = array[indexTo]
        val new = array[indexFrom]
        array[indexTo] = new
        array[indexFrom] = old
    }
}