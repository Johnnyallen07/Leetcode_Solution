package dataStructure.singlylinked;

import dataStructure.ListNode;


// LeetCode 1721
public class SwapIndex {


    // count the index
    public ListNode swapNodes(ListNode head, int k) {

        if (head == null) {
            return head;
        }

        ListNode copy = head;

        int size = LinkedListUtil.count(head);

        for (int i = 1; i < k; i++) {
            copy = copy.next;
        }

        int val1 = copy.val;

        int k2 = size - k;

        copy = head;
        for (int i = 0; i < k2; i++) {
            copy = copy.next;
        }

        int val2 = copy.val;

        copy = head;
        for (int i = 1; i < k; i++) {
            copy = copy.next;
        }
        copy.val = val2;

        copy = head;
        for (int i = 0; i < k2; i++) {
            copy = copy.next;
        }
        copy.val = val1;

        return head;
    }


}
