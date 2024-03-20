package dataStructure.singlylinked;

import dataStructure.ListNode;
import dataStructure.TreeNode;

// LeetCode 1367
public class LinkedinTree {

    public boolean isSubPath(ListNode head, TreeNode root) {

        //Check if a downward path is found starting from the root node.
        boolean ans = check(head, root);

        //If path is not found, check in the left and right subtrees.
        if (root!=null && !ans)
        {
            ans |= isSubPath(head, root.left);
            ans |= isSubPath(head, root.right);
        }

        return ans;
    }

    public boolean check(ListNode head, TreeNode root){

        //If the ListNode is null, we've reached the end of the list where all values match the ones in the tree. This means we've found a path.
        if (head==null)
            return true;

        //If the TreeNode is null, but the ListNode is not, we've reached the end of the subtree but not the list, so, return False.
        if (root==null)
            return false;

        //If the value of the current node matches the next node of the list, try to find a path in the left or right subtree, otherwise return False
        if (root.val==head.val)
            return check(head.next, root.left) || check(head.next, root.right);

        return false;

    }
}
