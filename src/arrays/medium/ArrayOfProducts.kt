package arrays.medium

object ArrayOfProducts {

    @JvmStatic
    fun main(args: Array<String>) {
        val input = listOf(5, 1, 4, 2)
        println(arrayOfProducts2(input))
    }

    fun arrayOfProducts(array: List<Int>): List<Int> {
        val output = mutableListOf<Int>()

        var firstProduct = 1
        array.subList(1, array.size).forEach {
            firstProduct *= it
        }
        output.add(firstProduct)

        for (i in 1 until array.size) {
            output.add((output[i-1] / checkForZero(array[i])) * array[i - 1])
        }

        return output
    }

    fun checkForZero(number: Int): Int {
        return if (number == 0) 1 else number
    }

    fun arrayOfProducts2(array: List<Int>): List<Int> {
        val output = MutableList(array.size) { 1 }

        var product = 1
        val leftProducts = IntArray(array.size) { 1 }

        array.forEachIndexed { index, num ->
            leftProducts[index] = product
            product *= num
        }

        product = 1
        val rightProducts = IntArray(array.size) { 1 }
        for (i in array.lastIndex downTo 0) {
            rightProducts[i] = product
            product *= array[i]
        }

        println(leftProducts.joinToString())
        println(rightProducts.joinToString())

        for (i in array.indices) {
            output[i] = leftProducts[i] * rightProducts[i]
        }

        return output
    }
}