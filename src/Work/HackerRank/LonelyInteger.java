package HackerRank;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class LonelyInteger {

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int res;

    int _a_size = Integer.parseInt(in.nextLine());
    int[] _a = new int[_a_size];
    int _a_item;
    String next = in.nextLine();
    String[] next_split = next.split(" ");

    for(int _a_i = 0; _a_i < _a_size; _a_i++) {
      _a_item = Integer.parseInt(next_split[_a_i]);
      _a[_a_i] = _a_item;
    }

    res = lonelyinteger(_a);
    System.out.println(res);

  }

  static int lonelyinteger(int[] a) {
    HashMap<Integer, Integer> val = new HashMap<Integer, Integer>();

    for (int i : a ) {
      if (val.containsKey(i)) {
        val.put(i, 2);
      } else {
        val.put(i, 1);
      }
    }

    for (int i : val.keySet()) {
      if (val.get(i) == 1)
        return i;
    }

    return 0;
  }
}