package dataStructure.singlylinked;

import dataStructure.ListNode;

import java.util.HashSet;

// LeetCode 141
public class LinkedCycle {


    public boolean hasCycle(ListNode head) {
        // brute force: store each of the node to a hash table
        // low memory, slow running time
        if (head == null){
            return false;
        }
        HashSet<ListNode> set = new HashSet<>();
        while (head.next != null) {
            if (set.contains(head)) {
                return true;
            } else {
                set.add(head);
            }
            head = head.next;
        }
        return false;
    }

    public boolean hasCycleII(ListNode head) {
        // fast-slow two pointer algorithm: if the list is a cycle:
        // the faster pointer will catch slower one at specific location
        // fast running time, more memory usage
        ListNode slow_pointer = head, fast_pointer = head;
        while (fast_pointer != null && fast_pointer.next != null) {
            slow_pointer = slow_pointer.next;
            fast_pointer = fast_pointer.next.next;
            if (slow_pointer == fast_pointer) {
                return true;
            }
        }
        return false;

    }

}
