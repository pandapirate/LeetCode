package String;

import java.util.HashMap;
import java.util.Map;

public class LongestUniqueSubstring {
  public int lengthOfLongestSubstring(String s) {
    if (s.length() <= 1) return s.length();
    Map<Character, Integer> map = new HashMap<>();

    int start = 0;
    int curLength = 1;
    int max = -1;
    map.put(s.charAt(0), 0);
    for (int i = 1; i < s.length(); i++) {
      char c = s.charAt(i);

      if (map.containsKey(c)) {
        if (map.get(c) == start) {
          //move everything up and keep going
          start++;
          map.put(c, i);
        } else {
          //compare the max, and move the start
          if (curLength > max)
            max = curLength;
          int index = map.get(c);
          for (int j = start; j <= index; j++) {
            map.remove(s.charAt(j));
          }
          start = index+1;
          map.put(c, i);
          curLength = i - start + 1;
        }
      } else {
        map.put(c, i);
        curLength = i - start + 1;
      }
    }
    if (max == -1)
      max = curLength;

    return max;
  }

  public static void main(String[] args) {
    String str = "wlrbbmqbhcdarzowkkyhiddqscdxrjmowfrxsjybldbefsarcbynecdyggxxpklorellnmpapqfwkhopkmco";

    System.out.println(new LongestUniqueSubstring().lengthOfLongestSubstring(str));
  }
}
