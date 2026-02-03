package Linkedlist;

import java.util.List;

public class CycleQuestions {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public boolean hasCycle(ListNode head){
        ListNode fast=head;
         
        
        ListNode slow=head;
        while(fast!=null && fast.next!==null){
            fast=fast.next.next;
            slow=slow.next;
            if(fast==slow){
                return true;
            }

        }
        return false;
    }

    // Find the length of the cycle
    public int lengthCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                // Calculate the length
                ListNode temp = slow;
                int length = 0;
                do {
                    temp = temp.next;
                    length++;
                } while (temp != slow);
                return length;
            }
        }
        return 0;
    }

    public ListNode detectcycle(ListNode head){
        int length=0;
        ListNode fast=head;
        ListNode slow=head;
        while(fast!=null && fast.next!==null){
            fast=fast.next.next;
            slow=slow.next;
            if(fast==slow){
                length=lengthCycle(slow);
                break;
            }
        }
        if(length==0){
            return null;
        }
        // find the start Node
        ListNode f=head;
        ListNode s=head;
        while(length>0){
            s=s.next;
            length--;
        }
        // Keep moving both forward and they will meet at cycle start
        while(f!=s){
            f=f.next;
            s=s.next;
        }
        return s;

    }

    // Happy Number
    public boolean isHappy(int n) {
        int slow = n;
        int fast = n;
        do {
            slow = findSquare(slow);
            fast = (findSquare(findSquare(fast)));
        } while (slow != fast);
        if (slow == 1) {
            return true;
        }
        return false;

    }

    private int findSquare(int num) {
        int ans = 0;
        while (num > 0) {
            int rem = num % 10;
            ans = ans + rem * rem;
            num = num / 10;
        }
        return ans;
    }

    // middle of linked list
    public ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
