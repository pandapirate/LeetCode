package Tree;

/**
 * Created by khuang on 8/27/14.
 */
public class UniqueBinaryTrees {
    public int numTrees(int n) {
        if (n <= 1)
            return 1;
        else {
            int sum = 0;
            for (int i = 1; i <= n; i++) {
                int left = numTrees(i-1);
                int right = numTrees(n-i);
                sum += left * right;
            }
            return sum;
        }
    }

    public static void main(String args[]) {
        System.out.println(new UniqueBinaryTrees().numTrees(3));
    }
}
