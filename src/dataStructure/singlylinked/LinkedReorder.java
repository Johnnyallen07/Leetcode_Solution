package dataStructure.singlylinked;


import dataStructure.ListNode;

// LeetCode 143
public class LinkedReorder {
    public void reorderList(ListNode head) {
        ListNode ans = new ListNode(-1);
        ans.next = head;

        // two-pointer approaches
        while (head != null && head.next !=null){
            ListNode cur = head.next;
            ListNode pre = head.next;

            while (pre.next.next != null){
                pre = pre.next;
            }

            cur = pre.next;
            // store the next element
            ListNode str = head.next;
            // break the link
            head.next = cur;
            cur.next = str;
            head = str;
            // avoid circling call
            pre.next = null;
        }

        head = ans.next;
    }





    // find the middle of the list, reverse the half of the list


    public void reorderListII(ListNode head) {
        ReverseLinkedList utils = new ReverseLinkedList();
        ListNode mid = LinkedListUtil.mid(head);
        ListNode midNext = mid.next;
        mid.next = null;
        ListNode p2 = utils.reverseList(midNext);
        ListNode p1 = head;

        ListNode temp;

        while(p1!=null && p2!=null){
            temp = p1.next;
            p1.next = p2;

            p1 = p2;
            p2 = temp;
        }
    }

    public static void main(String[] args) {
        LinkedReorder test = new LinkedReorder();
        ListNode head = TestCase.case1();
        test.reorderListII(head);

    }
}
