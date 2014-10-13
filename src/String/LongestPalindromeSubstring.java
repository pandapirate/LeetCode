package String;

import java.util.Random;

public class LongestPalindromeSubstring {

  public String longestPalindromeLinearTime(String s) {
    //stupid case
    if (s.length() <= 1) return s;

    //preprocess
    StringBuilder builder = new StringBuilder();
    for (int i = 0; i < s.length(); i++) {
      if (i != 0)
        builder.append('#');
      builder.append(s.charAt(i));
    }

    String processed = builder.toString();
//    System.out.println(processed);
    int[] P = new int[processed.length()];

    char[] T = processed.toCharArray();
    P[0] = 0;
    int a = 0;
    int maxA = P[a] + a;

    int curMax = 0;
    int maxIndex = 0;

    for (int i = 1; i < T.length; i++) {
      //find P[a]+a=max{ P[j]+j :  j<i }
      //rolling counter for max, compare last item with max
      if (P[i-1] + i-1 > maxA) {
        maxA = P[i-1] + i-1;
        a = i-1;
      }

      int min = 0;
      //if P[a]+a >= i then P[i] >= min{ P[2*a-i], 2*a-i-(a- P[a])}
      if (maxA >= i) {
        min = Math.min(P[2*a-i], 2*a-i-(a- P[a]));
      }

      // search starting with offset of min
      while(i - min >= 0 && i + min < T.length) {
        if (T[i-min] != T[i+min]) {
          break;
        }
        min++;
      }
      P[i] = min-1;

      if (P[i] > curMax) {
        curMax = P[i];
        maxIndex = i;
      }

//      for (int j : P) {
//        System.out.print(j);
//      }
//      System.out.println();
    }

    String maxStr = processed.substring(maxIndex - curMax, maxIndex + curMax + 1).replaceAll("#", "");

    return maxStr;
  }

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

  public static void main(String[] args) {
    String str = "ababaa";
    StringBuilder builder = new StringBuilder();
    Random rand = new Random();
    for (int i = 1; i < 10000000; i++) {
      int x = Math.abs(rand.nextInt());
//      String s = x + "aaa";
      builder.append(x);
    }
    str = builder.toString();
//    System.out.println(str);
    long time = System.currentTimeMillis();
    System.out.println(new LongestPalindromeSubstring().longestPalindromeLinearTime(str));
    System.out.println(System.currentTimeMillis() - time);

    time = System.currentTimeMillis();
    System.out.println(new LongestPalindromeSubstring().longestPalindrome(str));
    System.out.println(System.currentTimeMillis() - time);

  }
}
