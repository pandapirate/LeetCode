package Tree;

/**
 * Created by khuang on 8/26/14.
 */
public class PathSum {
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

    public static void main(String args[]) {

    }
}
