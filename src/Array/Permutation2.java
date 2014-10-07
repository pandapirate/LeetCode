package Array;

import java.util.*;

/**
 * Created by Kevin on 10/6/2014
 */
public class Permutation2 {
    /*
        Given a collection of numbers that might contain duplicates, return all possible unique permutations.

        For example,
        [1,1,2] have the following unique permutations:
        [1,1,2], [1,2,1], and [2,1,1].
     */

    Set<List<Integer>> results;

    public List<List<Integer>> permuteUnique(int[] num) {
        if (num.length == 0) return null;

        List<Integer> numbers = new ArrayList<>();
        for (int i : num)
            numbers.add(i);

//        Set<List<Integer>> results = slowPermute(numbers);

        results = new HashSet<>();
        permute(numbers, new ArrayList<Integer>());

        return new ArrayList<>(results);
    }

    private void permute(List<Integer> num, List<Integer> curList) {
        if (num.size() == 0) results.add(curList);
        else {
            for (int i = 0; i < num.size(); i++) {
                List<Integer> shortList = new ArrayList<>(num);
                int removed = shortList.remove(i);

                List<Integer> newList = new ArrayList<>(curList);
                newList.add(removed);
                permute(shortList, newList);
            }
        }
    }

    private Set<List<Integer>> slowPermute(List<Integer> num) {
        Set<List<Integer>> results = new HashSet<>();
        if (num.size() == 0)
            return results;

        for (int i = 0; i < num.size(); i++) {
            List<Integer> shortList = new ArrayList<>(num);
            int removed = shortList.remove(i);

            Set<List<Integer>> sublist = slowPermute(shortList);
            if (sublist.size() == 0) {
                List<Integer> newList = new ArrayList<>();
                newList.add(removed);
                results.add(newList);
            } else {
                for (List<Integer> sub : sublist) {
                    sub.add(0, removed);
                }
            }
            results.addAll(sublist);
        }

        return results;
    }

    public static void main(String args[]) {
        int[] list = new int[]{3,3,0,0,2,3,2};
        System.out.println(new Permutation2().permuteUnique(list));
    }
}
