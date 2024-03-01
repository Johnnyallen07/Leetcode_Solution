package solutions;

import utils.ListNode;
import utils.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CIX {
    private List<Integer> list;
    public TreeNode sortedListToBST(ListNode head) {
        // to convert to a height-balanced binary search tree, the size of the
        // linked list is important:
        list = linkedToList(head);
        int size = list.size();
        return binaryConstruct(0, size-1);
    }

    public TreeNode sortedListToBST(int[] head) {
        // to convert to a height-balanced binary search tree, the size of the
        // linked list is important:
        list = Arrays.stream(head)
                .boxed()
                .collect(Collectors.toList());
        int size = list.size();
        return binaryConstruct(0, size-1);
    }

    private TreeNode binaryConstruct(int low, int high){
        if (low > high) {
            return null;
        }
        int mid = low + (high - low) / 2;
        TreeNode node = new TreeNode(list.get(mid));

        node.left = binaryConstruct(low, mid - 1);
        node.right = binaryConstruct(mid + 1, high);
        return node;
    }

    private List<Integer> linkedToList(ListNode head){
        List<Integer> list = new ArrayList<>();
        while(head != null){
            list.add(head.val);
            head = head.next;
        }
        return list;
    }

    public static void main(String[] args) {
        ListNode test = new ListNode(-10);
        test.next = new ListNode(-3);
        test.next.next = new ListNode(0);
        test.next.next.next = new ListNode(5);
        test.next.next.next.next = new ListNode(9);
        new CIX().sortedListToBST(test);
    }
}
