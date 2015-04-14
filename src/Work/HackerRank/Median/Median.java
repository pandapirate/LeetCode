package HackerRank.Median;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Median {

  static ArrayList<Integer> list = new ArrayList<Integer>();

  public static void main(String[] args) throws Exception {
    Scanner in = new Scanner(System.in);

    in = new Scanner(new FileReader("E:\\Temp\\src\\HackerRank\\Median\\text"));

    int n = in.nextInt();

    for(int i = 0; i < n; i++) {
      String op = in.next();
      int val = in.nextInt();

      if (op.equals("r")){
        double r = newMedian(false, val);
        if (r == -1)
          System.out.println("Wrong!");
        else if (r == (int) r)
          System.out.println((int) r);
        else
          System.out.println(r);
      } else {
        double r = newMedian(true, val);
        if (r == (int) r)
          System.out.println((int) r);
        else
          System.out.println(r);
      }
    }
  }

  public static double newMedian (boolean add, int val) {
    if (add) {
      addValue(val);
    } else {
      removeValue(val);
    }

    if (list.size() == 0)
      return -1;

    int x = list.size()/2;

    if (list.size() % 2 == 0) {
      return (list.get(x) + list.get(x-1))/2.0;
    } else {
      return list.get(x);
    }
  }

  public static void removeValue(int val) {
    int first = 0;
    int last = list.size()-1;
    int mid = -1;
    boolean found = false;
    while (first <= last) {
      mid = first + (last - first)/2;
      if (list.get(mid) == val) {
        found = true;
        break;
      } else if (list.get(mid) < val) {
        first = mid+1;
      } else {
        last = mid-1;
      }
    }
    if (found)
      list.remove(mid);
  }

  public static void addValue(int val) {
    int size = list.size();
    if (size == 0) {
      list.add(val);
      return;
    }

    int first = 0;
    int last = list.size()-1;
    int mid = -1;
    boolean add = true;

    while (first <= last) {
      mid = first + (last - first)/2;
      if (list.get(mid) == val) {
        break;
      } else if (list.get(mid) < val) {
        if (mid + 1 == size) {
          list.add(val);
          add = false;
          break;
        } else if (mid + 1 < size && list.get(mid+1) >= val) {
          mid = mid + 1;
          break;
        } else {
          first = mid+1;
        }
      } else {
        if (mid == 0) {
          list.add(0, val);
          add = false;
          break;
        } else if (mid -1 >= 0 && list.get(mid-1) <= val) {
          mid = mid - 1;
          break;
        } else {
          last = mid-1;
        }
      }
    }

    if (add)
      list.add(mid, val);
  }
}
