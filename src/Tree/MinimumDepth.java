package Tree;

/**
 * Created by khuang on 8/26/14.
 */
public class MinimumDepth {
    static int min;

    public int minDepth(TreeNode root) {
        min = -1;
        if (root == null)
            return 0;

        traverse(root, 0);
        return min;
    }

    public void traverse(TreeNode root, int depth) {
        depth++;
        if (depth > min && min != -1)
            return;

        if (root.left != null) {
            traverse(root.left, depth);
        }

        if (root.right != null) {
            traverse(root.right, depth);
        }

        if (root.left == null && root.right == null) {
            if (depth < min || min == -1)
                min = depth;
        }
    }

    public static void main(String args[]) {

    }
}
