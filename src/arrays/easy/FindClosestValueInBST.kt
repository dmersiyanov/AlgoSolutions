package arrays.easy

import kotlin.math.abs

object FindClosestValueInBST {

    @JvmStatic
    fun main(args: Array<String>) {

    }

    fun findClosestValueInBst(tree: BST, target: Int): Int {
        return getClosestNode(target, tree.value, tree)
    }

    private fun getClosestNode(target: Int, closest: Int, node: BST?): Int {
        var newClosest = closest
        var closestNode = node

        // пока текущая вершина не null
        while (closestNode != null) {
            // если текущая разница между target и newClosest меньше чем разница между target и значением текущей ноды, то
            // обновляем значение newClosest
            if (abs(target - newClosest) > abs(target - closestNode.value)) {
                newClosest = closestNode.value
            }
            // если target меньше чем значение текущей ноды, то
            if (target < closestNode.value) {
                // то идем к левому потомку
                closestNode = closestNode.left

            // если target больше чем значение текущей ноды, то
            } else if (target > closestNode.value) {
                closestNode = closestNode.right
            } else {
                break
            }
        }
        return newClosest
    }

    open class BST(value: Int) {
        var value = value
        var left: BST? = null
        var right: BST? = null
    }

}