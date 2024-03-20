package Sort;

public class ReverseKNodes {
    public ListNode reverseKGroup(ListNode head, int k) {
        int size = 0;
        ListNode count = head;
        while (count != null){
            size++;
            count = count.next;
        }
        if (k == 1) return head;

        ListNode cache = null;
        ListNode storage = null;

        ListNode next = head;

        for (int i = 0; i < size / k; i++) {
            ListNode first = next;
            ListNode pre = next;
            head = next;
            head = head.next;

            for (int j = i * k + 1; j < (i + 1) * k - 1; j++) {
                next = head.next;
                head.next = pre;
                pre = head;
                head = next;
            }

            // reverse the middle



            next = head.next;
            head.next = pre;
            first.next = next; // reverse two sides

            // store the list:

            if (i == 0){
                cache = head;
                storage = cache;
            }
            else {
                for (int j = 0; j < k - 1 ; j++) {
                    cache = cache.next;
                }

                cache.next = head;
                cache = cache.next;
            }

        }

        return storage;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode one = new ListNode(2);
        ListNode two = new ListNode(3);
        ListNode three = new ListNode(4);
        ListNode four = new ListNode(5);
        ListNode five = new ListNode(6);
        ListNode six = new ListNode(7);
        ListNode seven = new ListNode(8);
        ListNode eight = new ListNode(9);
        ListNode nice = new ListNode(10);

        head.next=one;
        one.next=two;
        two.next=three;
        three.next=four;
        four.next=five;
        five.next=six;
        six.next=seven;
        seven.next=eight;
        eight.next=nice;

        ReverseKNodes test = new ReverseKNodes();
        test.reverseKGroup(head, 2);

    }
}
