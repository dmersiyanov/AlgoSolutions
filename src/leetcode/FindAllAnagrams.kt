package leetcode

object FindAllAnagrams {

    @JvmStatic
    fun main(args: Array<String>) {
        println(findAnagrams3("ycba", "abc"))
//        println(findAnagrams3("aab", "ab"))
    }

    fun findAnagrams(s: String, p: String): List<Int> {
        val output = mutableListOf<Int>()
        val pCharsCount = IntArray(26) { 0 }
        val a = 'a'
        p.forEachIndexed { index, c ->
            pCharsCount[c - a]++
        }
        var left = 0
        var right = 0
        var remainingWindowSize = p.length

        // Пока правая граница меньше длины строки s
        while (right < s.length) {
            // если символ в строке s по индексу right присутствует в искомой строке
            if (pCharsCount[s[right] - a] >= 1) {
                // Уменьшаем размер окна
                remainingWindowSize--
            }
            // убираем символ в строке s по индексу right из хеша искомой строки
            pCharsCount[s[right] - a]--
            // увеличиваем правую границу окна на 1
            right++

            // если мы дошли до конца окна и нашли все символы,то добавим начальный индекс в результат
            if (remainingWindowSize == 0) {
                output.add(left)
            }

            // если размер окна равен длине искомой строки и
            if (right - left == p.length) {
                // если символ по индексу left есть в искомой строке, то
                if (pCharsCount[s[left] - a] >= 0) {
                    // увеличиваем размер окна на 1
                    remainingWindowSize++

                }
                // добавляем символ в строке s по индексу right из хеша искомой строки
                pCharsCount[s[left] - a]++
                // сдвигаем левую границу окна на 1 влево
                left++
            }
        }

        return output
    }

    fun findAnagrams2(s: String, p: String): List<Int> {
        val output = mutableListOf<Int>()
        val charCount = IntArray(26) { 0 }
        for (char in p) {
            charCount[char - 'a']++
        }

        output.map {  }
        hashMapOf<String, String>().map {  }
        linkedSetOf<String>().map {  }
        hashSetOf<String>().asSequence().map {  }

        var left = 0
        var right = 0
        var balance = p.length

        while (right < s.length) {
            println("-------- new loop started (left - ${left}, right - ${right}) ---------")

            var currentCharIdx: Int = s[right] - 'a'
            charCount[currentCharIdx]--
            if (charCount[currentCharIdx] >= 0) {
                balance--
            }

            right++

            if (balance == 0) {
                output.add(left)
            }

            if (right - left == p.length) {
                currentCharIdx = s[left] - 'a'
                charCount[currentCharIdx]++
                if (charCount[currentCharIdx] >= 1) {
                    balance++
                }
                left++
            }
        }

        return output
    }


    fun findAnagrams3(s: String, p: String): List<Int> {
        val output = mutableListOf<Int>()
        // Считаем символы в строке p
        val charCount = IntArray(26) { 0 }
        val a = 'a'
        p.forEach {
            charCount[it - a]++
        }
        // переменные для метода скользящего окна
        var leftPointer = 0
        var rightPointer = 0
        var balance = p.length
        // идем по строке пока не дойдем по конца правым указателем
        while(rightPointer < s.length) {
            // проверяем есть ли в строки символ по правому указателю
            var currentChar = s[rightPointer]
            if(charCount[currentChar - a] >= 1) {
                balance--
            }
            charCount[currentChar - a]--
            rightPointer++
            // проверка баланса, если 0 то анаграмма найдена
            if(balance == 0) {
                output.add(leftPointer)
            }
            // проверем дошли ли до конца текущего окна (p.length)
            if(rightPointer - leftPointer == p.length) {
                currentChar = s[leftPointer]
                if(charCount[currentChar - a] >= 0) {
                    balance++
                }
                charCount[currentChar-a]++
                leftPointer++
            }
        }
        return output
    }
}

