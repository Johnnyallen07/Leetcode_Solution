package dataStructure.singlylinked;

// LeetCode 142

import dataStructure.ListNode;

import java.util.HashSet;

public class LinkedCycleII {

    // replace boolean to ListNode
    public ListNode detectCycle(ListNode head) {
        if (head == null){
            return null;
        }
        HashSet<ListNode> set = new HashSet<>();
        while (head.next != null) {
            if (set.contains(head)) {
                return head;
            } else {
                set.add(head);
            }
            head = head.next;
        }
        return null;
    }

    public ListNode detectCycleII(ListNode head) {
        /*** fast-slow algorithm should change because of the position

         their meeting position must be (n-m)th in the cycle, m refers to
         the number of nodes before getting into cycle, n refers to
         the number of nodes in the cycle
         */

        ListNode slow_pointer = head, fast_pointer = head;
        while (fast_pointer != null && fast_pointer.next != null) {
            slow_pointer = slow_pointer.next;
            fast_pointer = fast_pointer.next.next;
            if (slow_pointer == fast_pointer) {
                slow_pointer = head;
                while (slow_pointer != fast_pointer){
                    slow_pointer = slow_pointer.next;
                    fast_pointer = fast_pointer.next;
                }
                return slow_pointer;
            }

        }
        return null;
    }
}
