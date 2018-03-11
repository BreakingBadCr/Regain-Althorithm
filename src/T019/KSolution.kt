package T019

import java.util.*

fun main(args: Array<String>) {
    var listNode = KSolution.ListNode(1).apply {
        next = KSolution.ListNode(2).apply {
            next = KSolution.ListNode(3).apply {
                next = KSolution.ListNode(4).apply {
                    next = KSolution.ListNode(5).apply {
                        next = KSolution.ListNode(6)
                    }
                }
            }
        }
    }
    println(listNode.toString())
    print(KSolution().removeNthFromEndOfList(listNode, 4).toString())
}

class KSolution {

    data class ListNode(private var `val`: Int, var next: ListNode? = null) {
        override fun toString(): String {
            return if (next != null) {
                "$`val`->${next?.toString()}"
            } else "$`val`"
        }
    }

    fun removeNthFromEndOfList(head: ListNode?, n: Int): ListNode? {
        var preNode = head
        var afterNode = head
        var m = n
        val stack = Stack<ListNode>()
        var tmpNode: ListNode? = null
        while (afterNode != null) {
            stack.push(afterNode)
            afterNode = afterNode.next
        }

        while (m > 0 && stack.isNotEmpty()) {
            tmpNode = stack.pop()
            m--
        }

        if (tmpNode != null) {
            if (stack.isNotEmpty()) {
                stack.peek().next = tmpNode.next
            } else {
                preNode = tmpNode.next
            }
        }
        return preNode
    }


}