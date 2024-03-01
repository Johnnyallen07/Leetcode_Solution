package solutions;

import utils.TreeNode;

import java.lang.invoke.SerializedLambda;

public class CXXIV {

    /*
    The following annotated part is that we could not choose any path, so the minimum is 0
    But the question force us to choose at least one node, even the path is negative.

    public int maxPathSum(TreeNode root) {
        if (root.left == null && root.right == null){
            return root.val;
        }

        return helper(root, 0);
    }

    public int helper(TreeNode node, int sum){
        if (node == null){
            return sum;
        }
        int leftSum = Math.max(helper(node.left, sum), 0);
        int rightSum = Math.max(helper(node.right, sum),0);
        int nodeVal = node.val;

        return Math.max(rightSum, Math.max(leftSum, Math.max(leftSum + rightSum + nodeVal, nodeVal)));


    }

     */

    int max = Integer.MIN_VALUE;

    public int maxPath(TreeNode root) {

        if(root == null) return 0;

        int value = root.val;

        int left_sum = Math.max(maxPath(root.left),0);
        int right_sum = Math.max(maxPath(root.right),0);

        max = Math.max(max, left_sum + right_sum + value);

        return Math.max(left_sum, right_sum) + value;
    }

    public int maxPathSum(TreeNode root) {

        maxPath(root);
        return max;
    }

    public static void main(String[] args) {
        System.out.println(Integer.MIN_VALUE - 1);
    }
}
