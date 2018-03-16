package T021

import java.util.*

fun main(args: Array<String>) {
    var listNode = KSolution.ListNode(1).apply {
        next = KSolution.ListNode(2).apply {
            next = KSolution.ListNode(5).apply {
                next = KSolution.ListNode(7).apply {
                    next = KSolution.ListNode(9).apply {
                        next = KSolution.ListNode(10)
                    }
                }
            }
        }
    }

    var listNode2 = KSolution.ListNode(2).apply {
        next = KSolution.ListNode(2).apply {
            next = KSolution.ListNode(3).apply {
                next = KSolution.ListNode(4).apply {
                    next = KSolution.ListNode(6).apply {
                        next = KSolution.ListNode(8)
                    }
                }
            }
        }
    }
    print(T021.KSolution().mergeTwoSortedList(listNode ,  listNode2).toString())
}

class KSolution {
    data class ListNode(var `val`: Int, var next: ListNode? = null){
        override fun toString(): String {
            return if (next == null) "$`val`" else "$`val`->${next.toString()}"
        }
    }

    fun mergeTwoSortedList(list1: ListNode?, list2: ListNode?): ListNode? {
        var node1 = list1
        var node2 = list2
        var resultList: ListNode? = ListNode(0)
        val realResult = resultList
        while (node1 != null && node2!= null){
            if (node1.`val` <= node2.`val`){
                resultList?.next = node1
                node1 = node1.next
            }else{
                resultList?.next = node2
                node2=node2.next
            }
            resultList = resultList?.next
        }

        resultList?.next = if (node1 == null)node2 else node1
        return realResult?.next
    }
}