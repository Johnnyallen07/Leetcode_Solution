//package utils;
//
//import java.util.List;
//
//public class TreeNodeGenerator {
//    public static TreeNode listToTree(int[] arr){
//        if (arr.length == 0){
//            return new TreeNode();
//        }
//        TreeNode dummy = new TreeNode(-1);
//        TreeNode root = new TreeNode(arr[0]);
//        dummy.left = root;
//        for (int i = 0; i < arr.length; i++) {
//            if (root.val == 0){
//                root.val = arr[i];
//            }
//            else if (root.left.val == 0){
//                root.left.val = arr[i];
//            }
//            else if (root.right.val == 0){
//                root.right.val = arr[i];
//            }
//            else{
//                root = root.left;
//            }
//        }
//    }
////
////    public static TreeNode listToTree(List<Integer> arr){
////
////    }
// }
