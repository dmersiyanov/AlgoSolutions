package algoExpert.arrays.medium

object MoveElementToEnd {

    @JvmStatic
    fun main(args: Array<String>) {
        val array = mutableListOf(2, 1, 2, 2, 2, 3, 4, 2)
        val toMove = 2
        println(moveElementToEnd(array, toMove))
    }

    private fun moveElementToEnd(array: MutableList<Int>, toMove: Int): List<Int> {
        var endIdx = array.lastIndex
        var startIdx = 0
        while (startIdx < endIdx) {
            val num = array[startIdx]
            if (array[endIdx] == toMove) {
                endIdx--
                continue
            }
            if (num == toMove) {
                swap(array, startIdx, endIdx)
                endIdx--
            }
            startIdx++
        }

        return array
    }

    private fun swap(array: MutableList<Int>, fromIdx: Int, toIdx: Int) {
        val from = array[fromIdx]
        val to = array[toIdx]

        array[fromIdx] = to
        array[toIdx] = from
    }


}