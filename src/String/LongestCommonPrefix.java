package String;

/**
 * Created by Kevin on 10/14/2014.
 */
public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";
        if (strs.length == 1) return strs[0];

        // find shortest length
        int min = strs[0].length();
        String str = strs[0];
        for (String s : strs) {
            if (s.length() < min) {
                min = s.length();
                str = s;
            }
        }

        if (min > 0) {
            for (int i = min; i >= 0; i--) {
                String prefix = str.substring(0, i);
                boolean isPrefix = true;
                for (String s : strs) {
                    if (!s.startsWith(prefix)) {
                        isPrefix = false;
                        break;
                    }
                }

                if (isPrefix) {
                    return prefix;
                }
            }
        }

        return "";
    }

    public static void main (String[] args) {
        String[] list = new String[]{"aaaa", "aaa", "aaab", "aaadsafskld;fj"};

        System.out.println(new LongestCommonPrefix().longestCommonPrefix(list));
    }
}
