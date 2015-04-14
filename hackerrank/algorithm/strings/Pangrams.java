package algorithm.strings;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Created by khuang on 3/11/15.
 */
public class Pangrams {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);

        String word = in.nextLine().toLowerCase();

        Set<Character> c = new HashSet<>();

        for (int i = 0; i < word.length(); i++) {
            char cc = word.charAt(i);
            if (cc != ' ')
                c.add(cc);
            if (c.size() == 26) {
                System.out.println("pangram");
                return;
            }
        }

        System.out.println("not pangram");
    }
}
