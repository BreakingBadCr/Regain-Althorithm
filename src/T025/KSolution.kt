package T025

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
    print(KSolution().reversNodes(listNode2 , 3).toString())
}

class KSolution {
    data class ListNode(var `val`: Int, var next: ListNode? = null) {
        override fun toString(): String {
            return if (next == null) "$`val`" else "$`val`->${next.toString()}"
        }
    }

    fun reversNodes(listNode: ListNode?, index: Int): ListNode? {
        if (listNode == null || index == 1) return listNode
        var head = listNode
        fun reversNode(preNode: ListNode?, nextNode: ListNode?): ListNode? {
            var firstNode= preNode?.next
            var move = firstNode?.next
            while (move != nextNode){
                firstNode?.next = move?.next
                move?.next = preNode?.next
                preNode?.next =move
                move = firstNode?.next
            }
            return firstNode
        }
        val node :ListNode?= ListNode(0)
        var pre  = node
        node?.next = listNode
        var i = 1
        while (head != null){
            ++i
            if (i % index ==0){
                pre = reversNode(pre ,listNode.next)
                head = pre?.next
            }else{
                head = head.next
            }
        }
        return node?.next
    }
}