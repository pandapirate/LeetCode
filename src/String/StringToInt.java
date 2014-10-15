package String;

/**
 * Created by Kevin on 10/14/2014.
 */
public class StringToInt {
    public int atoi(String str) {
        String number = "";
        if (str.length() == 0) return 0;

        int index = 0;
        while (str.charAt(index) == ' ') {
            index++;
        }

        if (str.charAt(index) == '+' || str.charAt(index) == '-') {
            number += str.charAt(index);
            index++;
        }
        for (int i = index; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c >= 48 && c <= 57) {
                number += c;
            } else {
                break;
            }
        }

        try {
            long value = Long.parseLong(number);
            if (value > Integer.MAX_VALUE) return Integer.MAX_VALUE;
            else if (value < Integer.MIN_VALUE) return Integer.MIN_VALUE;
            else return Integer.parseInt(number);
        } catch (NumberFormatException e) {
            return 0;
        }
    }

    public static void main(String[] args) {
        String str = "2147483648";

        System.out.println(new StringToInt().atoi(str));
    }
}
