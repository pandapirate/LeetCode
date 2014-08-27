package Other;

/**
 * Created by khuang on 8/26/14.
 */
public class IntegerToRoman {

    public String intToRoman(int num) {
        int[] nums = new int[] {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] rom = new String[] {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        String str = "";
        int last = 0;
        while (num > 0) {
            for (int i = last; i < nums.length; i++) {
                if (num - nums[i] >= 0) {
                    str += rom[i];
                    num -= nums[i];
                    last = i;
                    break;
                }
            }
        }

        return str;
    }

    public static void main(String args[]) {

    }
}
