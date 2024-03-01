package solutions;

import utils.TreeNode;

import java.util.Arrays;

public class CV {

    /*
    public TreeNode buildTree(int[] preorder, int[] inorder) {

        return recursive(preorder, inorder);
    }

    public TreeNode recursive(int[] preorder, int[] inorder) {
        if (preorder.length == 0){
            return null;
        }
        if (preorder.length == 1) {
            return new TreeNode(preorder[0]);
        }
        TreeNode cur = new TreeNode(preorder[0]);
        int length = inorder.length;
        int curValue = preorder[0];
        int curIdx = indexOf(inorder, curValue);
        int[] inorderBefore = new int[curIdx];
        int[] inorderAfter = new int[length - curIdx - 1];
        int[] preorderBefore = new int[curIdx];;
        int[] preorderAfter = new int[length - curIdx - 1];
        for (int i = 0; i < curIdx; i++) {
            inorderBefore[i] = inorder[i];
            preorderBefore[i] = preorder[i + 1];
        }
        for (int i = curIdx + 1; i < preorder.length; i++) {
            inorderAfter[i - curIdx - 1] = inorder[i];
            preorderAfter[i - curIdx - 1] = preorder[i];
        }
        cur.left = recursive(preorderBefore, inorderBefore);
        cur.right = recursive(preorderAfter, inorderAfter);
        return cur;
    }*/

    private int i = 0;
    private int p = 0;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return build(preorder, inorder, Integer.MIN_VALUE);
    }

    private TreeNode build(int[] preorder, int[] inorder, int stop) {
        if (p >= preorder.length) {
            return null;
        }
        if (inorder[i] == stop) {
            ++i;
            return null;
        }

        TreeNode node = new TreeNode(preorder[p++]);
        node.left = build(preorder, inorder, node.val);
        node.right = build(preorder, inorder, stop);
        return node;
    }


    private int indexOf(int[] arr, int tar) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == tar) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] inorder = {2, 1, 4, 3, 5};
        int[] preorder = {1, 2, 3, 4, 5};

        new CV().buildTree(preorder, inorder);
    }

}
