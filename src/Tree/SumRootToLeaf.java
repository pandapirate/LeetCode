package Tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Kevin on 10/8/2014.
 */
public class SumRootToLeaf {
    /*
    Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.

    An example is the root-to-leaf path 1->2->3 which represents the number 123.

    Find the total sum of all root-to-leaf numbers.

    For example,

        1
       / \
      2   3
    The root-to-leaf path 1->2 represents the number 12.
    The root-to-leaf path 1->3 represents the number 13.

    Return the sum = 12 + 13 = 25.
    */

    private static List<String> numbers;

    public int sumNumbers(TreeNode root) {
        if (root == null) return 0;

        numbers = new ArrayList<String>();
        addNumbers("", root);
        int result = 0;

        for (String num : numbers) {
            result += Integer.parseInt(num);
        }

        return result;
    }

    public void addNumbers(String cur, TreeNode node) {
        cur += node.val;

        if (node.left == null && node.right == null) {
            //if this is a leaf, add to the list
            numbers.add(cur);
        } else {
            if (node.left != null)
                addNumbers(cur, node.left);
            if (node.right != null)
                addNumbers(cur, node.right);
        }
    }

    public static void main (String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        System.out.println(new SumRootToLeaf().sumNumbers(root));
    }
}
