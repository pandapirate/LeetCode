package HackerRank.QueueWithStack;

import java.util.ArrayList;

public class QueueWithStack {

  public static void main (String[] args) {

  }

  public class stack {
    ArrayList<Integer> list = new ArrayList<Integer>();

    public void push(int i) {
      list.add(i);
    }

    public int pop() {
      return list.remove(list.size() - 1);
    }
  }
}
