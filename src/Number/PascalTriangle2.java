package Number;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangle2 {
  public List<List<Integer>> generate(int numRows) {
    List<List<Integer>> triangle = new ArrayList<>();
    if (numRows >= 1) {
      List<Integer> newList = new ArrayList<>();
      newList.add(1);
      triangle.add(newList);
      if (numRows > 1) {
        for (int i = 1; i < numRows; i++) {
          List<Integer> list = new ArrayList<>();
          list.add(1);
          List<Integer> previousRow = triangle.get(i-1);
          for (int j = 0; j < previousRow.size(); j++) {
            if (j == previousRow.size()-1)
              list.add(1);
            else
              list.add(previousRow.get(j) + previousRow.get(j+1));
          }
          triangle.add(list);
        }
      }
    }
    return triangle;
  }

  public List<Integer> getRow(int rowIndex) {
    List<Integer> curList = null;
    if (rowIndex >= 0) {
      curList = new ArrayList<>();
      curList.add(1);
      if (rowIndex > 0) {
        for (int i = 0; i < rowIndex; i++) {
          List<Integer> list = new ArrayList<>();
          list.add(1);
          for (int j = 0; j < curList.size(); j++) {
            if (j == curList.size()-1)
              list.add(1);
            else
              list.add(curList.get(j) + curList.get(j+1));
          }
          curList = list;
        }
      }
    }
    return curList;
  }

  public static void main(String[] args) {
    System.out.println(new PascalTriangle2().getRow(0));
  }
}
