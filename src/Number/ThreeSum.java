package Number;

import java.util.*;

/**
 * Created by Kevin on 9/16/2014.
 */
public class ThreeSum {

    public List<List<Integer>> threeSum(int[] num) {
        //sum to 0
        Set<List<Integer>> results = new HashSet<>();
        Arrays.sort(num);
        for (int i = 0; i < num.length; i++) {
            int n = num[i];
            int start = i+1, end = num.length-1;
            while (start < end) {
                if (num[start] + num[end] == -n) {
                    List<Integer> newList = new ArrayList<>();
                    newList.add(n);
                    newList.add(num[start]);
                    newList.add(num[end]);
                    Collections.sort(newList);
                    results.add(newList);
                    start++;
                    end--;
                } else if (num[start] + num[end] > -n) {
                    end--;
                } else {
                    start++;
                }
            }
        }

        return new ArrayList<>(results);
    }

    public static void main(String[] args) {
        int[] list = new int[]{-1, 0, 1, 2, -1, -4};

        System.out.println(new ThreeSum().threeSum(list));
    }
}
