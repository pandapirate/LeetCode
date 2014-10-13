package Array;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Kevin on 10/7/2014
 */
public class PascalTriangle {
    /*Given numRows, generate the first numRows of Pascal's triangle.

    For example, given numRows = 5,
    Return

    [
            [1],
           [1,1],
          [1,2,1],
         [1,3,3,1],
        [1,4,6,4,1]
    ]
            */
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

    public static void main(String args[]) {
        List<List<Integer>> results = new PascalTriangle().generate(5);
        for (List<Integer> list : results)
            System.out.println(list);
    }
}
