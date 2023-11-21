package algoExpert.arrays

object TwoNumberSum {

    @JvmStatic
    fun main(arg: Array<String>) {
        println(twoNumberSum2(mutableListOf(3, 5, -4, 8, 11, 1, -1, 6), 10))
    }

    // hash table
    fun twoNumberSum2(array: MutableList<Int>, targetSum: Int): List<Int> {
        val hashMap = mutableMapOf<Int, Boolean>()
        array.forEach { firstNum ->
            val secondNum = targetSum - firstNum
            if (hashMap.containsKey(secondNum)) {
                return listOf(firstNum, secondNum)
            } else {
                hashMap[firstNum] = true
            }
        }
        return listOf()
    }

    // two pointers
    fun twoNumberSum(array: MutableList<Int>, targetSum: Int): List<Int> {
        array.sort()

        var leftIdx = 0
        var rightIdx = array.lastIndex

        for (i in 0..array.size) {
            val startNum = array[leftIdx]
            val endNum = array[rightIdx]
            val sum = startNum + endNum

            if (sum == targetSum) {
                return listOf(startNum, endNum)
            } else if (sum > targetSum && rightIdx > leftIdx) {
                rightIdx--
            } else if (sum < targetSum && leftIdx < rightIdx) {
                leftIdx++
            }
        }

        return listOf()
    }


}