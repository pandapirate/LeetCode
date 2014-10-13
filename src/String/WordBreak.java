package String;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by khuang on 9/2/14.
 */
public class WordBreak {

    public boolean wordBreak(String s, Set<String> dict) {
        if (s == null || s.length() == 0) return false;
        else if (dict.contains(s)) return true;

        HashSet<String> results = new HashSet<>();
        results.add(s);

        while (!foundWord(results, dict)) {
            HashSet<String> newResults = new HashSet<>();
            for (String str : results) {
                for (int i = 0; i <= str.length(); i++) {
                    if (dict.contains(str.substring(0, i))) {
                        if (i == str.length())
                            return true;
                        else
                            newResults.add(str.substring(i));
                    }
                }
            }
            results = newResults;
            if (results.size() == 0)
                return false;
        }

        return true;
    }

    private boolean foundWord(Set<String> results, Set<String> dict) {
        for (String str : results) {
            if (dict.contains(str))
                return true;
        }
        return false;
    }

    public static void main(String args[]) {
        String s = "leetcodes";
        HashSet<String> dict = new HashSet<>();
        dict.add("leet");
        dict.add("code");

        System.out.println(new WordBreak().wordBreak(s, dict));
    }
}
