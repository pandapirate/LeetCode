package Tree;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/*
 * Created by Kevin on 10/14/2014.
 */
public class LevelOrderTraversal2 {

    private static List<List<Integer>> results;

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        results = new ArrayList<List<Integer>>();
        if (root == null) return results;

        traverse(root, 0);
        Collections.reverse(results);
        return results;
    }

    private void traverse(TreeNode node, int depth) {
        List<Integer> base = results.size() > depth ? results.get(depth) : new ArrayList<Integer>();
        base.add(node.val);
        if (results.size() <= depth) {
            results.add(base);
        }

        if (node.left != null) {
            traverse(node.left, depth+1);
        }

        if (node.right != null) {
            traverse(node.right, depth+1);
        }
    }

    public static void main(String args[]) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        List<List<Integer>> val = new LevelOrderTraversal2().levelOrderBottom(root);
        System.out.println(val);
    }
}
