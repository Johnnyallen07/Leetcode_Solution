package solutions;

import utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class CII {


    public static void main(String[] args) {
        TreeNode root = new TreeNode(3, new TreeNode(9), new TreeNode(20));
        root.left.left = null;
        root.left.right = null;
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        new CII().levelOrder(root);
    }
    // classic bfs problem
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) return new ArrayList<>();
        bfs(List.of(root), ans, 0);
        return ans;
    }

    private void bfs(List<TreeNode> nodeList, List<List<Integer>> ans, int depth){

        List<Integer> ints = new ArrayList<>();
        for (TreeNode element : nodeList){
            ints.add(element.val);
        }
        List<TreeNode> next = new ArrayList<>();
        ans.add(ints);
        for (int i = 0; i < nodeList.size(); i++) {
            TreeNode node = nodeList.get(i);
            if (node.left != null){
                next.add(node.left);

            }
            if (node.right != null){
                next.add(node.right);

            }
        }
        if (!next.isEmpty()){
            bfs(next, ans, ++depth);
        }

    }
}
