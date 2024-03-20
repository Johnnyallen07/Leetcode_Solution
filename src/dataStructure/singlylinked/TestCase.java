package dataStructure.singlylinked;

import dataStructure.ListNode;

public class TestCase {
    public static ListNode case1(){
        ListNode head = new ListNode(1);
        ListNode II = new ListNode(2);
        ListNode III = new ListNode(3);
        ListNode IV = new ListNode(4);
        ListNode V = new ListNode(5);
        head.next = II;
        II.next = III;
        III.next = IV;
        IV.next = V;
        return head;
    }
}
