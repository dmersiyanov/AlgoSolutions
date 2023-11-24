package algoExpert.arrays.easy

object NonConstructibleChange {

    @JvmStatic
    fun main(args: Array<String>) {
        val input = mutableListOf(1, 2, 5)
        println(nonConstructibleChange(input))
    }

    private fun nonConstructibleChange(coins: MutableList<Int>): Int {
        var maxChange = 0
        coins.sort()
        coins.forEach { coin ->
            if (coin > (maxChange + 1)) {
                return ++maxChange
            } else {
                maxChange += coin
            }
        }
        return ++maxChange
    }

}