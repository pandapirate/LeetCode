package Tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by khuang on 8/27/14.
 */
public class PostOrderTraversal {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();

        if (root != null)
            traverse(list, root);

        return list;
    }

    private void traverse(List<Integer> list, TreeNode curNode) {
        if (curNode.left != null)
            traverse(list, curNode.left);
        if (curNode.right != null)
            traverse(list, curNode.right);
        list.add(curNode.val);

    }

    public static void main(String args[]) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);

        List<Integer> val = new PostOrderTraversal().postorderTraversal(root);
        System.out.println(val);
    }
}
