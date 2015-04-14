package LeetCode;

import java.util.ArrayList;

public class PathSum {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

//    private class SumNode {
//        TreeNode curNode;
//        int sum;
//        public SumNode(TreeNode tn, int s) {
//            curNode = tn;
//            sum = s;
//        }
//    }

    public static boolean hasPath = false;
    public static int targetValue;

    private void searchPath(TreeNode base, int curSum) {
        if (hasPath)
            return;

        int sum = base.val + curSum;
        if (sum == targetValue && base.left == null && base.right == null) {
            hasPath = true;
            return;
        } else {
            if (base.left != null)
                searchPath(base.left, sum);
            if (base.right != null)
                searchPath(base.right, sum);
        }
    }

    public boolean hasPathSum(TreeNode root, int sum) {
        targetValue = sum;
        hasPath = false;
        if (root != null){
            searchPath(root, 0);
        }
        return hasPath;
    }

    public static void main (String args[]) {
        /*    5
             / \
            4   8
           /   / \
          11  13  4
         /  \      \
        7    2      1
        */

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
//        root.right = new TreeNode(8);
//        root.left.left = new TreeNode(11);
//        root.left.left.left = new TreeNode(7);
//        root.left.left.right = new TreeNode(2);
//
//        root.right.left = new TreeNode(13);
//        root.right.right = new TreeNode(4);
//        root.right.right.right = new TreeNode(1);

        PathSum sum = new PathSum();
        System.out.println(sum.hasPathSum(root, 1));
    }
}
