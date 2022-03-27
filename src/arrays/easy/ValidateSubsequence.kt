package arrays.easy

object ValidateSubsequence {

    @JvmStatic
    fun main(arg: Array<String>) {
        val array = listOf(5, 1, 22, 25, 6, -1, 8, 10)
        val sequence = listOf(22)
        println(isValidSubsequence(array, sequence))
    }

    fun isValidSubsequence(array: List<Int>, sequence: List<Int>): Boolean {
        var seqIdx = 0
        array.forEach {
            if (seqIdx == sequence.size) {
                return@forEach
            }
            if (it == sequence[seqIdx]) {
                seqIdx++
            }
        }
        return seqIdx == sequence.size
    }
}