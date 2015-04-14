package HackerRank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class MissingNumbers {

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int res;

    int n = Integer.parseInt(in.nextLine());
    int[] list = new int[n];
    int a;
    String line = in.nextLine();
    String[] line_split = line.split(" ");

    for(int i = 0; i < n; i++) {
      a = Integer.parseInt(line_split[i]);
      list[i] = a;
    }

    n = Integer.parseInt(in.nextLine());
    int[] list2 = new int[n];
    line = in.nextLine();
    line_split = line.split(" ");

    for(int i = 0; i < n; i++) {
      a = Integer.parseInt(line_split[i]);
      list2[i] = a;
    }

    missingNumbers(list, list2);
  }

  public static void missingNumbers(int[] a, int[] b){
    HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

    for (int i : b) {
      if (map.containsKey(i))
        map.put (i, map.get(i) + 1);
      else
        map.put (i, 1);
    }

    for (int i : a) {
      if (map.containsKey(i)) {
        int v = map.get(i);
        if (v > 1)
          map.put(i, v-1);
        else
          map.remove(i);
      }
    }

    ArrayList<Integer> list = new ArrayList<Integer>();

    for (int i : map.keySet()) {
      for (int j = 0; j < map.get(i); j++) {
        list.add(i);
      }
    }

    int[] array = new int[list.size()];
    for (int x = 0; x < list.size(); x++) {
      array[x] = list.get(x);
    }

    int[] sorted = mergeSort(array);

    for (int x : sorted) {
      System.out.print(x + " ");
    }
  }

  public static int[] mergeSort(int[] array) {

    if (array.length == 1)
      return array;

    int half = array.length/2;
    int[] left = new int[half];
    int[] right = new int[array.length - half];

    for (int i = 0; i < half; i++) {
      left[i] = array[i];
    }

    for (int i = half; i < array.length; i++) {
      right[i - half] = array[i];
    }

    return merge(mergeSort(left), mergeSort(right));
  }

  private static int[] merge(int[] left, int[] right) {
    int l = 0, r = 0;
    int[] result = new int[left.length + right.length];
    int counter = 0;
    while (counter != result.length) {
      if (l < left.length && r < right.length) {
        if (left[l] < right[r]) {
          result[counter] = left[l];
          counter++;
          l++;
        } else {
          result[counter] = right[r];
          counter++;
          r++;
        }
      } else if (l == left.length) {
        for (int i = r; i < right.length; i++) {
          result[counter] = right[i];
          counter++;
          l++;
        }
      } else if (r == right.length) {
        for (int i = l; i < left.length; i++) {
          result[counter] = left[i];
          counter++;
          r++;
        }
      }
    }

    return result;
  }

}
