package Tree;

/**
 * Created by Kevin on 10/11/2014.
 */
public class BalancedTree {

    /*
    Given a binary tree, determine if it is height-balanced.

    For this problem, a height-balanced binary tree is defined as a
    binary tree in which the depth of the two subtrees of every node
    never differ by more than 1.
    */

    private static boolean balanced;

    public boolean isBalanced(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) return true;

        balanced = true;

        depth(root, 0);

        return balanced;
    }

    private int depth(TreeNode root, int depth) {
        depth += 1;

        if (root.left == null && root.right == null) return depth;

        int left = root.left == null ? depth : depth(root.left, depth);
        int right = root.right == null ? depth : depth(root.right, depth);

        if (Math.abs(left - right) > 1) {
            balanced = false;
            return -1;
        }

        return Math.max(left, right);
    }

    public static void main (String[] args) {

    }
}
