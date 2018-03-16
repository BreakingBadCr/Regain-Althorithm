package T024

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
    print(KSolution().swapPair(listNode2).toString())
}

class KSolution {
    data class ListNode(var `val`: Int, var next: ListNode? = null) {
        override fun toString(): String {
            return if (next == null) "$`val`" else "$`val`->${next.toString()}"
        }
    }

    fun swapNodeInPair(listNode: ListNode?): ListNode? {
        if (listNode == null || listNode.next == null) return listNode
        val node = listNode.next
        listNode.next = swapNodeInPair(node?.next)
        node?.next = listNode
        return node
    }
    fun swapPair(listNode: ListNode?):ListNode?{
        if (listNode?.next == null) return listNode
        val preNode :ListNode?= ListNode(0)
        var curNode = preNode
        preNode?.next = listNode
        while (curNode?.next != null && curNode.next?.next != null){
            var tempNode = curNode.next?.next
            curNode.next?.next = tempNode?.next
            tempNode?.next = curNode.next
            curNode.next = tempNode
            curNode = curNode.next?.next
        }
        return preNode?.next
    }

    fun swapPairsValue(listNode: ListNode?):ListNode?{
        if (listNode?.next == null){
            return listNode
        }
        var pre = listNode
        var nextNode = pre.next
        while (pre!=null && nextNode != null){
            val temp = nextNode.`val`
            nextNode.`val` = pre.`val`
            pre.`val`= temp
            pre = nextNode.next
            nextNode = pre?.next
        }
        return listNode
    }
}