package algorithm.arrays;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by khuang on 10/5/14.
 */
public class MakeItAnagram {

    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);

        String line1 = in.nextLine();
        String line2 = in.nextLine();

        Map<Character, Integer> map = new HashMap<Character, Integer>();

        for (int i = 0; i < line1.length(); i++) {
            char c = line1.charAt(i);
            if (map.containsKey(c)) {
                map.put(c, map.get(c) +1);
            } else
                map.put(c, 1);
        }

        int n = 0;
        for (int i = 0; i < line2.length(); i++) {
            char c = line2.charAt(i);
            if (map.containsKey(c)) {
                if (map.get(c) == 1) {
                    map.remove(c);
                } else {
                    map.put(c, map.get(c)-1);
                }
            } else {
                n++;
            }
        }

        for (char c : map.keySet()) {
            n += map.get(c);
        }

        System.out.println(n);
    }
}
