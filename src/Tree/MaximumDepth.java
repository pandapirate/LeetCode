package Tree;

/**
 * Created by khuang on 8/26/14.
 */
public class MaximumDepth {
    static int max;

    public int maxDepth(TreeNode root) {
        max = 0;
        if (root != null)
            traverse(root, 0);
        return max;
    }

    public void traverse(TreeNode node, int depth) {
        depth++;
        if (depth > max)
            max = depth;

        if (node.left != null)
            traverse(node.left, depth);

        if (node.right != null)
            traverse(node.right, depth);
    }

    public static void main(String args[]) {

    }
}
