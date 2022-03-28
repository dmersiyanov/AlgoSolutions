package arrays.hard

// O(n) time, O(n) space
object LargestRange {

    @JvmStatic
    fun main(args: Array<String>) {
        val array = listOf(4, 2, 1, 3, 6)
        println(largestRange(array))
    }

    fun largestRange(array: List<Int>): Pair<Int, Int> {
        val numberToVisitedMap = mutableMapOf<Int, Boolean>()
        // перекладываем числа в массив
        array.forEach {
            numberToVisitedMap[it] = false
        }

        // вспомогательные переменные для пары и ее длины
        var bestRange = Pair(-1, -1)
        var bestRangeLength = 0

        for (i in array.indices) {
            val number = array[i]

            if (numberToVisitedMap.getOrDefault(number, true)) {
                // если номер обработан идем дальше
                continue
            } else {

                // помечаем номер как обработанный
                numberToVisitedMap[number] = true
                var left = number - 1
                var right = number + 1
                var currentLength = 1

                // идем влево пока такой номер есть в мапе
                while (numberToVisitedMap.containsKey(left)) {
                    numberToVisitedMap[left] = true
                    left--
                    currentLength++
                }

                // идем вправо пока такой номер есть в мапе
                while (numberToVisitedMap.containsKey(right)) {
                    numberToVisitedMap[right] = true
                    right++
                    currentLength++
                }

                // проверяем текущую и лучшую длину
                if (bestRangeLength < currentLength) {
                    bestRangeLength = currentLength
                    bestRange = Pair(++left, --right)
                }
            }
        }

        return bestRange
    }
}