package Array;

import java.util.Arrays;

/**
 * Created by Kevin on 9/14/2014
 */
public class RemoveDuplicateFromSortedArray {
    public int removeDuplicates(int[] A) {
        if (A.length <=1)
            return A.length;

        int curVal = A[0];
        int curIndex = 1;

        for (int i = 1; i < A.length; i++) {
            if (A[i] != curVal) {
                curVal = A[i];
                A[curIndex] = curVal;
                curIndex++;
            }
        }
        return curIndex;
    }

    public static void main(String args[]) {
        int[] array = new int[]{1, 1, 2, 3, 3, 3, 4, 5, 6, 6, 6, 7, 7, 8, 8, 9, 10};

        printArray(array);
        int i = new RemoveDuplicateFromSortedArray().removeDuplicates(array);
        System.out.println(i);
        printArray(array);
    }

    public static void printArray(int[] array) {
        for (int i = 0; i < array.length; i++)
            System.out.print(array[i] + " ");
        System.out.println();
    }
}
