package solutions;

import utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class XCVIII {
    // classic dfs problem

    public static void main(String[] args) {
        TreeNode root = new TreeNode(2, new TreeNode(1), new TreeNode(3));

        System.out.println(new XCVIII().isValidBST(root));
    }

    private long minVal = Long.MIN_VALUE;

    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        if (!isValidBST(root.left)) return false;
        if (minVal >= root.val) return false;
        minVal = root.val;
        return isValidBST(root.right);
    }
}
