package Random;

import java.util.*;

public class IteratorRandom {

  public static Map<Integer, Integer> results;
  public static Random rand = new Random();

  public static void main (String[] args) {
    results = new HashMap<>();

    List<Integer> baseSet = new ArrayList<>();
    for (int i = 1; i <= 20; i++) {
      baseSet.add(i);
    }

    for (int i = 0; i < 1000; i++) {
      List<Integer> newSet = new ArrayList<>(baseSet);
      countValues(getRandom(newSet, 10));
    }

    for (Integer x : results.keySet()) {
      System.out.println(x + " - " + results.get(x));
    }
  }

  public static List<Integer> getRandom(List<Integer> list, int num) {
    List<Integer> result = new ArrayList<>();
    Set<Integer> firstSet = new HashSet<>();

    for (int x : list) {
      if (result.size() < num) {
        result.add(x);
        firstSet.add(x);
      } else {
        int index = rand.nextInt(num+1);
        if (index < num) {
          result.set(index, x);
        }
      }
    }

    for (int x : firstSet) {
      if (result.contains(x)) {
        continue;
      }
      int index = rand.nextInt(num+1);
      if (index < num) {
        result.set(index, x);
      }
    }
    return  result;
  }

  public static void countValues(List<Integer> list) {
    for (Integer i : list) {
      Integer x = results.get(i);
      if (x == null) {
        x = 0;
      }
      x++;
      results.put(i, x);
    }
  }
}
