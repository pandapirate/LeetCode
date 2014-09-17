package Number;

import java.util.Arrays;

/**
 * Created by Kevin on 9/16/2014.
 */
public class TwoSum {

    public int[] twoSum(int[] numbers, int target) {
        int[] copy = Arrays.copyOf(numbers, numbers.length);
        Arrays.sort(numbers);

        int start = 0;
        int end = numbers.length-1;

        while (start < end) {
            if (numbers[start] + numbers[end] == target) {
                break;
            } else if (numbers[start] + numbers[end] > target) {
                end--;
            } else
                start++;
        }

        int[] results = new int[2];
        for (int i = 0; i < copy.length; i++) {
            if (results[0] == 0 && copy[i] == numbers[start]) {
                results[0] = i+1;
                if (results[1] > 0) break;
            } else if (results[1] == 0 && copy[i] == numbers[end]) {
                results[1] = i+1;
                if (results[0] > 0) break;
            }
        }
        Arrays.sort(results);
        return results;
    }

    public static void main(String[] args) {
        int[] list = new int[]{0, 4, 3, 0};

        int[] results = new TwoSum().twoSum(list, 0);
        System.out.println(results[0] + " " + results[1]);
    }
}
