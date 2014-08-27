package Number;

/**
 * Created by khuang on 8/26/14.
 */
public class ReverseInt {

    public int reverse(int x) {
        int reversedNum = 0;
        boolean negative = x < 0 ? true : false;
        while (x != 0) {
            int last = x % 10;
            reversedNum = reversedNum * 10 + last;
            x = x / 10;
        }
        return reversedNum;
    }

    public static void main(String args[]) {
        ReverseInt x = new ReverseInt();

        System.out.println(x.reverse(1234));
    }
}
