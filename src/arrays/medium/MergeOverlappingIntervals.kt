package arrays.medium

import kotlin.math.max

object MergeOverlappingIntervals {

    @JvmStatic
    fun main(args: Array<String>) {
        val intervals = listOf(listOf(100, 105), listOf(1, 104))
        val expected = listOf(listOf(1, 2), listOf(3, 8), listOf(9, 10))
        println(mergeOverlappingIntervals(intervals))
    }

    fun mergeOverlappingIntervals(intervals: List<List<Int>>): List<List<Int>> {
        val sortedIntervals = intervals.sortedBy { it.first() }
        val result = mutableListOf(sortedIntervals.first())

        for (i in 1 until intervals.size) {
            val current = result.last()
            val next = sortedIntervals[i]

            if (current[1] >= next[0]) {
                result[result.lastIndex] = listOf(current[0], max(current[1], next[1]))
            } else {
                result.add(next)
            }
        }

        return result
    }
}