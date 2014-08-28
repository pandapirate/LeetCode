package Tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by khuang on 8/27/14.
 */
public class PreOrderTraversal {

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();

        if (root != null)
            traverse(list, root);

        return list;
    }

    private void traverse(List<Integer> list, TreeNode curNode) {
        list.add(curNode.val);
        if (curNode.left != null)
            traverse(list, curNode.left);
        if (curNode.right != null)
            traverse(list, curNode.right);
    }

    public static void main(String args[]) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(3);
        root.right = new TreeNode(2);

        List<Integer> val = new PreOrderTraversal().preorderTraversal(root);
        System.out.println(val);
    }
}
