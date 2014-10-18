package Number;

/**
 * Created by Kevin on 10/18/2014.
 */
public class CountAndSay {
    /*
     *
     The count-and-say sequence is the sequence of integers beginning as follows:
     1, 11, 21, 1211, 111221, ...

     1 is read off as "one 1" or 11.
     11 is read off as "two 1s" or 21.
     21 is read off as "one 2, then one 1" or 1211.
     Given an integer n, generate the nth sequence.

     Note: The sequence of integers will be represented as a string.
     */

    public String countAndSay(int n) {
        if (n == 1) return "1";

        String base = "1";
        return performCountAndSay(base, n-1);
    }

    private String performCountAndSay(String str, int n) {
        if (n == 0) return str;

        StringBuilder newStr = new StringBuilder();
        int count = 1;
        char cur = str.charAt(0);
        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i) == cur) {
                count++;
            } else {
                newStr.append(count);
                newStr.append(cur);
                count = 1;
                cur = str.charAt(i);
            }
        }
        newStr.append(count);
        newStr.append(cur);
        return performCountAndSay(newStr.toString(), n-1);
    }

    public static void main(String[] args) {
        System.out.println(new CountAndSay().countAndSay(2));
    }
}
