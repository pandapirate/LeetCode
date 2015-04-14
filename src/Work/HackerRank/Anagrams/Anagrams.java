package HackerRank.Anagrams;

import java.util.HashMap;

public class Anagrams {

  public static void main (String[] args) {

    HashMap<String, String> testCase = new HashMap<String, String>();
    testCase.put("secure", "rescue");
    testCase.put("google", "facebook");
    testCase.put("conifers", "fir cones");

    for (String s : testCase.keySet()) {
      System.out.println(s + " -> " + testCase.get(s) + " : " + isAnagram(s, testCase.get(s)));
    }
  }

  public static boolean isAnagram(String start, String end) {
    HashMap<Character, Integer> map = new HashMap<Character, Integer>();
    start = start.replaceAll(" ", "");
    end = end.replaceAll(" ", "");
    for (int i = 0; i  < start.length()-1; i++) {
      char c = start.charAt(i);
      if (map.containsKey(c)) {
        map.put(c, map.get(c) + 1);
      }  else
        map.put(c, 1);
    }

    for (int i = 0; i < end.length()-1; i++) {
      char c = start.charAt(i);
      if (!map.containsKey(c) ) {
        return false;
      }

      if (map.get(c) == 0)
        return false;

      map.put(c, map.get(c) -1);
    }

    for (char c : map.keySet()) {
      if (map.get(c) != 0) {
        return false;
      }
    }

    return true;
  }
}
