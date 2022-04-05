package arrays.hard

import kotlin.math.max

object MinRewards {

    @JvmStatic
    fun main(args: Array<String>) {
//        println(minRewards2(listOf(8, 4, 2, 1, 3, 6, 7, 9, 5)))
        println(minRewards3(listOf(5, 10)))
    }

    // O(n^2) time, O(n) space
    fun minRewards(scores: List<Int>): Int {
        val rewards = IntArray(scores.size) { 1 }

        for (i in 1 until scores.size) {

            val previous = scores[i - 1]
            val current = scores[i]

            if (current > previous) {
                rewards[i] = rewards[i - 1] + 1
            } else {
                for (j in i - 1 downTo 0) {
                    if (scores[j] > scores[j + 1]) {
                        rewards[j] = max(rewards[j], rewards[j + 1] + 1)
                    }
                }
            }
        }

        return rewards.sum()
    }

    // O(n) time, O(n) space
    fun minRewards2(scores: List<Int>): Int {
        val rewards = IntArray(scores.size) { 1 }
        val localMinIdxs = findLocalMins(scores)

        localMinIdxs.forEach {
            expandFromLocalMin(it, scores, rewards)
        }

        return rewards.sum()
    }

    private fun expandFromLocalMin(localMinIdx: Int, scores: List<Int>, rewards: IntArray) {
        var leftIdx = localMinIdx - 1
        while (leftIdx >= 0 && scores[leftIdx] > scores[leftIdx + 1]) {
            rewards[leftIdx] = max(rewards[leftIdx], rewards[leftIdx + 1] + 1)
            leftIdx--
        }
        var rightIdx = localMinIdx + 1
        while (rightIdx <= scores.lastIndex && scores[rightIdx] > scores[rightIdx - 1]) {
            rewards[rightIdx] = rewards[rightIdx - 1] + 1
            rightIdx++
        }
    }

    private fun findLocalMins(scores: List<Int>): List<Int> {
        val output = mutableListOf<Int>()
        if (scores.size == 1) {
            return output.apply {
                add(0)
            }
        }
        for (i in scores.indices) {
            if (i == 0 && scores[i] < scores[i + 1]) {
                output.add(i)
            }
            if (i == scores.lastIndex && scores[i] < scores[i - 1]) {
                output.add(i)
            }
            if (i == 0 || i == scores.lastIndex) {
                continue
            }
            if (scores[i] < scores[i - 1] && scores[i] < scores[i + 1]) {
                output.add(i)
            }
        }
        return output
    }

    fun minRewards3(scores: List<Int>): Int {
        val output = IntArray(scores.size) { 1 }
        if (scores.size == 1) {
            return 1
        }
        for (i in 1 until scores.lastIndex) {
            val current = scores[i]
            val previous = scores[i - 1]
            if (previous < current) {
                output[i] = output[i - 1] + 1
            }
        }

        for (i in scores.lastIndex downTo 1) {
            val current = scores[i]
            val previous = scores[i - 1]
            if (current < previous) {
                output[i - 1] = max(output[i - 1], output[i] + 1)
            }
        }

        return output.sum()

    }
}