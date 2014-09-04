package Tree;

import java.util.List;

/**
 * Created by Kevin on 9/3/14
 */
public class ConvertSortedArrayToBinaryTree {
    public TreeNode sortedArrayToBST(int[] num) {
        if (num.length == 0) return null;
        return convert(num, 0, num.length-1);
    }

    private TreeNode convert(int[] nums, int low, int high) {
        if (low > high) return null;

        int mid = low + (high - low)/2;
        TreeNode node = new TreeNode(nums[mid]);

        node.left = convert(nums, low, mid-1);
        node.right = convert(nums, mid+1, high);

        return node;
    }

    public static void main(String args[]) {
        int[] list = new int[]{1, 3, 4, 5, 6, 7, 8, 9, 10};

        TreeNode node = new ConvertSortedArrayToBinaryTree().sortedArrayToBST(list);
        node.print();
    }
}
