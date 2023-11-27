package algoExpert.arrays.medium

object ThreeNumberSum {

    @JvmStatic
    fun main(args: Array<String>) {
        val array = mutableListOf(12, 3, 1, 2, -6, 5, -8, 6)
        val targetSum = 0
        println(threeNumberSum(array, targetSum))
    }

    private fun threeNumberSum(array: MutableList<Int>, targetSum: Int): List<List<Int>> {
        val result = mutableListOf<List<Int>>()

        array.sort()

        array.forEachIndexed { index, firstNum ->
            var startIdx = index + 1
            var endIdx = array.lastIndex

            while (startIdx < endIdx) {
                val secondNum = array[startIdx]
                val thirdNum = array[endIdx]

                val checkSum = firstNum + secondNum + thirdNum

                if (checkSum == targetSum) {
                    result.add(listOf(firstNum, secondNum, thirdNum))
                    startIdx++
                    endIdx--
                } else if (checkSum > targetSum) {
                    endIdx--
                } else {
                    startIdx++
                }
            }
        }

        return result
    }


}