package dataStructure.singlylinked;

import dataStructure.ListNode;

public class LinkedListUtil {

    // take the first half of the list
    public static ListNode mid(ListNode head){
        ListNode slow = head;
        ListNode fast = head;
        while(fast!=null && fast.next!=null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    public static ListNode reverse(ListNode head) {
        ListNode prev = null;


        while(head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }

    public static int count(ListNode head){
        ListNode str = new ListNode(-1);
        str.next = head;
        int num = 0;
        while (str.next != null){
            str = str.next;
            num++;
        }
        return num;
    }
}
