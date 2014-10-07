package String;

/**
 * Created by khuang on 10/6/14.
 */
public class LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
        if (s.length() <= 1) return s;

        String str = s.charAt(0) + "";
        for (int i = 0; i < s.length()-1; i++) {
            String odd = expand(s, i, i);
            if (odd.length() > str.length())
                str = odd;
            String even = expand(s, i, i+1);
            if (even.length() > str.length())
                str = even;
        }

        return str;
    }

    private String expand(String s, int l, int r) {
        int shift = 0;
        int low = l;
        int high = r;
        while (low >= 0 && high <= s.length()-1 && s.charAt(low) == s.charAt(high)) {
            shift++;
            low--;
            high++;
        }
        if (shift == 0)
            return "";
        else {
            shift--;
            return s.substring(l-shift, r+shift+1);
        }
    }

    public static void main(String args[]) {
        String str = "cabbaa";
        System.out.println(new LongestPalindromicSubstring().longestPalindrome(str));
    }
}
