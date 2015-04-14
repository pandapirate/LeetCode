package HackerRank;


import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class Triplets {

  public static void main(String[] args) throws Exception {
    Scanner in = new Scanner(System.in);
    in = new Scanner(new FileReader("E:\\Temp\\src\\HackerRank\\TestData\\triplet-test"));

    int n = in.nextInt();
    int[] list = new int[n];

    for(int i = 0; i < n; i++) {
      list[i] = in.nextInt();;
    }

    ArrayList<Integer> condensed = condenseList(list);
    printTriplets(condensed);
  }

  private static ArrayList<Integer> condenseList(int[] list) {
    ArrayList<Integer> condensed = new ArrayList<Integer>();

    int prev = -1;
    for (int i : list) {
      if (i == prev) {
        continue;
      } else {
        condensed.add(i);
        prev = i;
      }
    }

    return condensed;
  }

  public static void printTriplets(ArrayList<Integer> list) {
    int counter = 0;
    HashSet<Integer> used = new HashSet<Integer>();
    for (int i = 0; i < list.size() - 2; i++) {
      int ii = list.get(i);
      for (int j = i + 1; j < list.size() - 1; j++) {
        int jj = list.get(j);
        if (jj > ii) {
          for (int k = j + 1; k < list.size(); k++) {
            if (list.get(k) > jj) {
              int code = getCode(ii, jj, list.get(k));
              if (!used.contains(code)) {
                counter++;
                System.out.println(code + " - (" + ii + "," + jj + "," + list.get(k) + ")");
                used.add(code);
              }
            }
          }
        }
      }
    }
    System.out.println(counter);
  }

  public static int getCode(int a, int b, int c) {
    int hash = 17;
    hash = hash * 31 + a;
    hash = hash * 31 + b;
    hash = hash * 31 + c;

    return hash;
  }
}
