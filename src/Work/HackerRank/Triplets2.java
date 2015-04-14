package HackerRank;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class Triplets2 {

  public static void main(String[] args) throws Exception {
    Scanner in = new Scanner(System.in);
    in = new Scanner(new FileReader("E:\\Temp\\src\\HackerRank\\TestData\\triplet-test"));

    int n = in.nextInt();
    int[] list = new int[n];

    for(int i = 0; i < n; i++) {
      list[i] = in.nextInt();;
    }

    ArrayList<Node> processed = processList(list);
    printTriplets(processed);
  }

  public static ArrayList<Node> processList(int[] list) {
    ArrayList<Node> nodes = new ArrayList<Node>();

    int prev = -1;
    for (int i = 0; i < list.length; i++) {
      if (list[i] == prev) {
        continue;
      } else {
        prev = list[i];
        Node newNode = new Node(list[i]);
        for (Node n : nodes) {
          if (n.baseVal < prev) {
            n.add(newNode);
          }
        }

        nodes.add(newNode);
      }
    }

    return nodes;
  }


  private static void printTriplets(ArrayList<Node> condensed) {
    HashSet<Integer> used = new HashSet<Integer>();

    for (Node n : condensed) {
      for (Node nn : n.nodes) {
        for (Node nnn : nn.nodes) {
          used.add(getCode(n.baseVal, nn.baseVal, nnn.baseVal));
        }
      }
    }

    System.out.println(used.size());
  }

  private static int getCode(int a, int b, int c) {
    int hash = 17;
    hash = hash * 31 + a;
    hash = hash * 31 + b;
    hash = hash * 31 + c;

    return hash;
  }

  private static class Node {
    ArrayList<Node> nodes = new ArrayList<Node>();
    int baseVal;

    public Node(int base) {
      baseVal = base;
    }

    public void add(Node n) {
      nodes.add(n);
    }
  }
}
