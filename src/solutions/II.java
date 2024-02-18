package solutions;

import utils.ListNode;

public class II {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode ans = new ListNode(0);
        ListNode copy = ans;
        int carry = 0;

        while(l1 != null || l2 != null || carry == 1){ // carry == 1 for the edge case like 9 + 1 = 10
            int sum = 0;
            if(l1 != null){
                sum += l1.val;
                l1 = l1.next;
            }
            if(l2 != null){
                sum += l2.val;
                l2 = l2.next;
            }
            sum += carry;
            carry = sum/10;
            ListNode node = new ListNode(sum % 10);
            copy.next = node;
            copy = copy.next;
        }
        return ans.next;
    }

    public static void main(String[] args) {
        ListNode arr1 = new ListNode(9);
        ListNode arr2 = new ListNode(1);
        new II().addTwoNumbers(arr1, arr2);
    }


}
