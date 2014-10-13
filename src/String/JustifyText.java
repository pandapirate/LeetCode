package String;

import java.util.ArrayList;
import java.util.List;

/*
 * Created by Kevin on 10/11/2014.
 */
public class JustifyText {

    /*
     Given an array of words and a length L, format the text such that each line has exactly L characters and is fully (left and right) justified.

     You should pack your words in a greedy approach; that is, pack as many words as you can in each line. Pad extra spaces ' ' when necessary so that each line has exactly L characters.

     Extra spaces between words should be distributed as evenly as possible. If the number of spaces on a line do not divide evenly between words, the empty slots on the left will be assigned more spaces than the slots on the right.

     For the last line of text, it should be left justified and no extra space is inserted between words.

     For example,
     words: ["This", "is", "an", "example", "of", "text", "justification."]
     L: 16.

     Return the formatted lines as:
     [
     "This    is    an",
     "example  of text",
     "justification.  "
     ]
     Note: Each word is guaranteed not to exceed L in length.
     */

    public List<String> fullJustify(String[] words, int L) {
        List<String> results = new ArrayList<String>();

        String str = null;
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            if (str != null && str.length() + 1 + word.length() > L) {
                //justify the past line
                str = justify(str, L, false);
                results.add(str);
                str = word;
            } else if (str == null) {
                str = word;
            } else {
                str += " " + word;
            }
        }

        if (str == null)
            return results;

        results.add(justify(str, L, true));
        return results;
    }

    private String justify(String s, int L, boolean lastLine) {
        if (s.length() == L)
            return s;

        String[] words = s.split(" ");
        if (words.length == 1) {
            //left align, fill rest with blanks
            StringBuilder str = new StringBuilder(words[0]);
            int spaces = L - s.length();
            for (int i = 0; i < spaces; i++) {
                str.append(" ");
            }
            return str.toString();
        }

        if (lastLine) {
            StringBuilder str = new StringBuilder(s);
            int spaces = L - s.length();
            for (int i = 0; i < spaces; i++) {
                str.append(" ");
            }
            return str.toString();
        }

        int length = s.replaceAll(" ", "").length();
        int spaces = L - length;
        int numSpaces = words.length-1;
        int spaceWidth = spaces / numSpaces;
        int remainder = spaces - (numSpaces * spaceWidth);

        StringBuilder str = new StringBuilder(words[0]);

        for (int i = 1; i < words.length; i++) {
            if (i == words.length - 1) {
                for (int j = 0; j < remainder; j++) {
                    str.append(" ");
                }
            }

            for (int j = 0; j < spaceWidth; j++) {
                str.append(" ");
            }
            str.append(words[i]);
        }

        return str.toString();
    }

    public static void main (String[] args) {
        String[] text = new String[]{"Here","is","an","example","of","text","justification."};

        List<String> results = new JustifyText().fullJustify(text, 16);

        for (String str : results) {
            System.out.println(str + "~~~~~ " + str.length());
        }
    }
}
