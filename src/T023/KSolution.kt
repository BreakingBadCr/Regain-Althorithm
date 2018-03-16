package T023

import java.util.*

fun main(args: Array<String>) {
    var listNode = KSolution.ListNode(1).apply {
        next = KSolution.ListNode(2).apply {
            next = KSolution.ListNode(4).apply {
                next = KSolution.ListNode(7).apply {
                    next = KSolution.ListNode(8).apply {
                        next = KSolution.ListNode(19)
                    }
                }
            }
        }
    }

    var listNode2 = KSolution.ListNode(3).apply {
        next = KSolution.ListNode(6).apply {
            next = KSolution.ListNode(8).apply {
                next = KSolution.ListNode(12).apply {
                    next = KSolution.ListNode(14).apply {
                        next = KSolution.ListNode(16)
                    }
                }
            }
        }
    }
    var listNode3 = KSolution.ListNode(1).apply {
        next = KSolution.ListNode(5).apply {
            next = KSolution.ListNode(7).apply {
                next = KSolution.ListNode(9).apply {
                    next = KSolution.ListNode(11)
                }
            }
        }
    }
    print(T023.KSolution().mergeKListNode(arrayOf(listNode , listNode2 ,listNode3)).toString())
}

class KSolution {
    data class ListNode(var `val`: Int, var next: ListNode? = null) {
        override fun toString(): String {
            return if (next == null) "$`val`" else "$`val`->${next.toString()}"
        }
    }

    fun mergeKListNode(listNodes: Array<ListNode>): ListNode? {
        if (listNodes.isEmpty()) return null
        val queue: PriorityQueue<ListNode> = PriorityQueue(listNodes.size, Comparator<ListNode> { o1, o2 ->
            return@Comparator if (o1.`val` < o2.`val`) -1 else if (o1.`val` == o2.`val`) 0 else 1
        })

        val resultNode: ListNode? = ListNode(0)
        var tempNode = resultNode
        listNodes.forEach { it ->
            queue.add(it)
        }

        while (!queue.isEmpty()) {
            tempNode?.next = queue.poll()
            tempNode = tempNode?.next
            if (tempNode?.next != null) queue.add(tempNode.next)
        }

        return resultNode?.next
    }
}