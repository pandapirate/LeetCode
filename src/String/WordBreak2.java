package String;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by khuang on 9/2/14.
 */
public class WordBreak2 {

    private class Words {
        public String current;
        public String remains;

        public Words(String cur, String rem) {
            current = cur;
            remains = rem;
        }


    }

    public List<String> wordBreak(String s, Set<String> dict) {
        if (s == null || s.length() == 0) return new ArrayList<String>();

        HashSet<Words> words = new HashSet<>();
        words.add(new Words("", s));

        while (true) {
            boolean found = false;
            HashSet<Words> newWords = new HashSet<>();
            for (Words word : words) {
                for (int i = 0; i <= word.remains.length(); i++) {
                    String substr = word.remains.substring(0, i);
                    if (dict.contains(substr)) {
                        found = true;
                        String newWord = word.current.length() == 0 ? substr : (word.current + " " + substr);
                        newWords.add(new Words(newWord, word.remains.substring(i)));
                    }
                }
            }
            if (found) {
                words = newWords;
            } else {
                break;
            }
        }

        HashSet<String> results = new HashSet<>();
        for (Words w : words) {
            if (w.remains.length() == 0)
                results.add(w.current);
        }

        return new ArrayList<String>(results);
    }

    public static void main(String args[]) {
        String s = "catsanddog";
        HashSet<String> dict = new HashSet<>();
        dict.add("cat");
        dict.add("cats");
        dict.add("and");
        dict.add("sand");
        dict.add("dog");

        System.out.println(new WordBreak2().wordBreak(s, dict));
    }
}
