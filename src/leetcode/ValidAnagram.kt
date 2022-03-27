package leetcode

object ValidAnagram {

    @JvmStatic
    fun main(args: Array<String>) {
        println(isAnagram("cat", "atc"))
    }

    fun isAnagram(s: String, t: String): Boolean {
        if (s.length != t.length) {
            return false
        }
        val charCount = Array(26) { 0 }
        val a = 'a'
        s.forEachIndexed { index, c ->
            charCount[s[index] - a]++
            charCount[t[index] - a]--
        }
        for (char in charCount) {
            if (char != 0) {
                return false
            }
        }
        return true
    }
}