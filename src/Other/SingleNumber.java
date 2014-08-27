package Other;

/**
 * Created by khuang on 8/26/14.
 */
public class SingleNumber {
    public int singleNumber(int[] A) {
        int x = 0;
        for (int i : A) {
            x = x ^ i;
        }
        return x;
    }

    public static void main(String args[]) {
        SingleNumber num = new SingleNumber();

        System.out.println(num.singleNumber(new int[]{1, 2, 3, 4, 5, 1, 2, 3, 4, 6, 6}));
    }
}
