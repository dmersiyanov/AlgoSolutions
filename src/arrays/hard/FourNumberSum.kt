package arrays.hard

object FourNumberSum {

    @JvmStatic
    fun main(args: Array<String>) {
        println(fourNumberSum(mutableListOf(7, 6, 4, -1, 1, 2), 16))
    }

    fun fourNumberSum(array: MutableList<Int>, targetSum: Int): List<List<Int>> {
        val quadruplets = mutableListOf<List<Int>>()
        val pairs = hashMapOf<Int, MutableList<List<Int>>>()

        // внешний цикл
        for (i in 1 until array.size - 1) {
            // внутренний цикл с первого до последнего элемента
            for (j in i + 1 until array.size) {
                val currentSum = array[i] + array[j]
                val diff = targetSum - currentSum
                if (pairs.containsKey(diff)) {
                    pairs[diff]?.forEach {
                        quadruplets.add(mutableListOf<Int>().apply {
                            addAll(it)
                            add(array[i])
                            add(array[j])
                        })
                    }
                }
            }
            // обратный цикл для добавления пар
            for (k in 0 until i) {
                val sum = array[i] + array[k]
                if (pairs.containsKey(sum)) {
                    pairs[sum]?.add(listOf(array[i],array[k]))
                } else {
                    pairs[sum] = mutableListOf(listOf(array[i],array[k]))
                }
            }
        }

        return quadruplets
    }
}