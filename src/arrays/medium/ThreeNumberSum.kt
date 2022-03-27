package arrays.medium

object ThreeNumberSum {

    @JvmStatic
    fun main(args: Array<String>) {
        println(threeNumberSum(mutableListOf(8, 10, -2, 49, 14), 57))
    }

    fun threeNumberSum(array: MutableList<Int>, targetSum: Int): List<List<Int>> {
        val output = mutableListOf<List<Int>>()
        array.sort()
        var currentIdx = 0

        while (currentIdx < array.size - 2) {
            var rightIdx = array.lastIndex
            var leftIdx: Int = currentIdx+1

            while (leftIdx < rightIdx) {
                    val currentNum = array[currentIdx]
                    val leftNum = array[leftIdx]
                    val rightNum = array[rightIdx]
                    val total = currentNum + leftNum + rightNum

                    if (total == targetSum) {
                        output.add(listOf(currentNum, leftNum, rightNum).sorted())
                        leftIdx++
                        rightIdx--
                    } else if (total < targetSum) {
                        leftIdx++
                    } else {
                        rightIdx--
                    }
            }

            currentIdx++
        }

        return output
    }
}