package HackerRank;

import java.util.ArrayList;
import java.util.Scanner;

public class ClosestNumber {

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

    closestNumbers(list);
  }

  private static void closestNumbers(int[] list) {
    int[] newList = mergeSort(list);

    int difference = 2147483647;
    ArrayList<Integer> minList = new ArrayList<Integer>();

    for (int i = 0; i < list.length-1; i++) {
      int diff = Math.abs(newList[i] - newList[i+1]);

      if (diff < difference) {
        minList.clear();
        minList.add(newList[i]);
        minList.add(newList[i+1]);
        difference = diff;
      } else if (diff == difference) {
        minList.add(newList[i]);
        minList.add(newList[i+1]);
      }
    }

    for (int i : minList) {
      System.out.print(i + " ");
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
