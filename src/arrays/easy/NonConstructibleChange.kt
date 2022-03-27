package arrays.easy

object NonConstructibleChange {
    @JvmStatic
    fun main(args: Array<String>) {
        val input = mutableListOf(1, 1, 3)
        println(nonConstructibleChange(input))
    }

    fun nonConstructibleChange(coins: MutableList<Int>): Int {
        var currentChange = 0
        coins.sort()

        coins.forEach {
            if (it > currentChange + 1) {
                return currentChange + 1
            }
            currentChange += it
        }

        return currentChange + 1
    }

}