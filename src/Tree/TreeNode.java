package Tree;

/**
 * Created by khuang on 8/26/14.
 */
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }

    public void print() {
        String leftStr = left== null ? "#" : "";
        String rightStr = right== null ? "#" : "";
        System.out.print(val);
        if (left == null && right == null)
            System.out.print("");
        else {
            System.out.print(":(");
            if (left == null) System.out.print("#");
            else left.print();
            System.out.print("/");
            if (right == null) System.out.print("#");
            else right.print();
        }

        System.out.print(")");
    }
}
