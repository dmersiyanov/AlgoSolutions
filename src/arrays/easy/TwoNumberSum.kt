package arrays.easy

object TwoNumberSum {

    @JvmStatic
    fun main(args: Array<String>) {
        println(twoNumberSum3(mutableListOf(3, 5, -4, 8, 11, 1, -1, 6), 10))
    }

    fun twoNumberSum(array: MutableList<Int>, targetSum: Int): List<Int> {
        array.forEachIndexed { index, firstNumber ->
            val nextIndex = index + 1
            array.subList(if (nextIndex <= array.lastIndex) nextIndex else array.lastIndex, array.lastIndex)
                .forEach { secondNumber ->
                    if (firstNumber + secondNumber == targetSum) {
                        return listOf(firstNumber, secondNumber)
                    }
                }
        }
        return listOf<Int>()
    }

    fun twoNumberSum2(array: MutableList<Int>, targetSum: Int): List<Int> {
        val numbersMap = mutableMapOf<Int, Boolean>()

        array.forEach {
            val possibleMatch = targetSum - it
            if (numbersMap.containsKey(possibleMatch)) {
                println("pair found, y = $possibleMatch, x = $it")
                return listOf(possibleMatch, it)
            } else {
                println("pair not found, y = $possibleMatch, x = $it")
                numbersMap[it] = true
            }
            println(numbersMap.toString())
        }
        return emptyList()
    }

    fun twoNumberSum3(array: MutableList<Int>, targetSum: Int): List<Int> {
        array.sort()
        var left = 0
        var right = array.lastIndex
        while (left < right) {
            val x = array[left]
            val y = array[right]
            val currentSum = x + y
            if (currentSum == targetSum) {
                return listOf(x, y)
            } else if (currentSum > targetSum) {
                right--
            } else {
                left++
            }
        }
        return emptyList()
    }
}