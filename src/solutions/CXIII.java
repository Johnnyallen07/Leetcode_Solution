package solutions;

import utils.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CXIII {

    private List<List<Integer>> ans = new ArrayList<>();
    private int targetSum;
    private TreeNode root;

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        this.targetSum = targetSum;
        this.root = root;
        dfs(new ArrayList<>(), root, 0);
        return ans;
    }

    private void dfs(List<Integer> possibleSum, TreeNode node, int sum) {
        if (node == null){
            return;
        }
        int len = possibleSum.size();
        possibleSum.add(node.val);
        sum += node.val;
        if (sum == targetSum && (node.left == null && node.right == null)){
            List<Integer> result = new ArrayList<>(possibleSum);
            ans.add(result);
        }
        // backtrack

        dfs(possibleSum, node.left, sum);
        dfs(possibleSum, node.right, sum);
        possibleSum.remove(len);
        sum -= node.val;

    }

}
