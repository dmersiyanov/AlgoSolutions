package algoExpert.arrays.medium

object IsMonotonic {

    @JvmStatic
    fun main(args: Array<String>) {
        val array = listOf(1, 2)
        println(isMonotonic2(array))
    }

    private fun isMonotonic2(array: List<Int>): Boolean {
        var nonInc = true
        var nonDec = true

        for (i in 1..array.lastIndex) {
            val current = array[i - 1]
            val next = array[i]

            if (current > next) {
                nonDec = false
            } else if (current < next) {
                nonInc = false
            }
        }

        return nonInc || nonDec
    }

    private fun isMonotonic(array: List<Int>): Boolean {
        if (array.size > 1) {

            var isAsc: Boolean? = null

            for (i in 0..array.lastIndex - 1) {
                val cur = array[i]
                val next = array[i + 1]

                if (isAsc == null) {
                    if (cur > next) {
                        isAsc = false
                    } else if (cur < next) {
                        isAsc = true
                    }
                } else {
                    if (isAsc && cur > next) {
                        return false
                    } else if (!isAsc && cur < next) {
                        return false
                    }
                }
            }

        } else {
            return true
        }

        return true
    }

}