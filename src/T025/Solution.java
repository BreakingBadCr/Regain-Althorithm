package T025;

public class Solution {
    public static void main(String[] args){
        ListNode listNode = new ListNode(0) ;
        ListNode listNode1 = new ListNode(2) ;
        ListNode listNode2 = new ListNode(4) ;
        ListNode listNode3 = new ListNode(5) ;
        ListNode listNode4 = new ListNode(6) ;
        ListNode listNode5 = new ListNode(7) ;
        listNode.next = listNode1 ;
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;
        System.out.print(new Solution().reverseKGroup(listNode , 3).toString());
    }
    public static class ListNode {
        public int val;
        public ListNode next;

        public ListNode(int val) {
            this.val = val;
        }

        @Override
        public String toString() {
            if (next != null) {
                return this.val + "->" + next.toString();
            }else {
                return String.valueOf(val);
            }
        }
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k == 1) {
            return head;
        }
        ListNode node = new ListNode(0), pre = node;
        node.next = head;
        for (int i = 1; head != null; ++i) {
            if (i % k == 0) {
                pre = reverse(pre, head.next);
                head = pre.next;
            } else {
                head = head.next;
            }
        }
        return node.next;
    }

    public ListNode reverse(ListNode pre, ListNode nex) {
        ListNode head = pre.next;
        ListNode move = head.next;
        while (move != nex) {
            head.next = move.next;
            move.next = pre.next;
            pre.next = move;
            move = head.next;
        }
        return head;
    }
}
