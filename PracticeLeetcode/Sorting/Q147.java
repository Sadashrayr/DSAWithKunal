package PracticeLeetcode.Sorting;

public class Q147 {
    /* Insertion sort in linked list */

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode insertionSortList(ListNode head) {
        if (head == null) {
            return head;
        }

        ListNode node = new ListNode(0);
        ListNode current = new ListNode();
        while (current != null) {
            ListNode prev = node;
            while (prev.next != null && prev.next.val < current.val) {
                prev = prev.next;
            }
            ListNode next = current.next;
            current.next = prev.next;
            current = next;
        }
        return node.next;
    }

}
