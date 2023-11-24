package algoExpert.arrays.easy

object ValidateSubsequence {
    @JvmStatic
    fun main(args: Array<String>) {
        val array = listOf(5, 1, 22, 25, 6, -1, 8, 10)
        val sequence = listOf(1, 6, -1, 10)
        println(isValidSubsequence(array, sequence))
    }

    private fun isValidSubsequence(array: List<Int>, sequence: List<Int>): Boolean {
        var seqIdx = 0

        array.forEach {
            if (seqIdx < sequence.size) {
                val seqNum = sequence[seqIdx]
                if (seqNum == it) {
                    if (seqIdx == sequence.lastIndex) {
                        return true
                    }
                    seqIdx++
                }
            }
        }
        return false
    }
}