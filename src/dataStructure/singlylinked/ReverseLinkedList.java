package dataStructure.singlylinked;

import dataStructure.ListNode;

public class ReverseLinkedList {

    // LeetCode 206
    // replace next to prev
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;


        while(head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }

    // LeetCode 92
    // copy prev twice, temp for copy the whole list; cur for the reverse operation

    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode temp = new ListNode(-1);
        ListNode prev = temp;
        temp.next = head;

        for (int i = 0; i < left - 1; i++) {
            prev = prev.next;
        }

        ListNode cur = prev.next;

        for (int i = 0; i < right - left; i++) {
            // record current node
            ListNode ptr = prev.next;
            // reverse next node
            prev.next = cur.next;
            // increment
            cur.next = cur.next.next;
            // add node from the start
            prev.next.next = ptr;
        }

        return temp.next;
    }

    public static void main(String[] args) {
        ReverseLinkedList test = new ReverseLinkedList();
        ListNode head = TestCase.case1();
        test.reverseBetween(head,2,4);
    }
}
