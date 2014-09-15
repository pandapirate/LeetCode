package Array;

/**
 * Created by Kevin on 9/14/2014
 */
public class MergeSortedArray {
    public void merge(int A[], int m, int B[], int n) {
        int index = A.length-1;

        int aTracker = m-1;
        int bTracker = n-1;
        while (aTracker >= 0 && bTracker >= 0) {
//            printArray(A);
            if (A[aTracker] > B[bTracker]) {
                A[index--] = A[aTracker--];
            } else {
                A[index--] = B[bTracker--];
            }
        }

        if (bTracker >= 0) {
            for (int i = index; i >= 0; i--) {
                A[i] = B[bTracker--];
            }
        }

    }

    public static void main(String args[]) {
        int[] a = new int[10];
        a[0] = 1;
        a[1] = 3;
        a[2] = 5;
        a[3] = 7;
        a[4] = 9;
        int[] b = new int[]{2, 4, 6, 8, 10};

        new MergeSortedArray().merge(a, 5, b, 5);
        for (int i = 0; i < 10; i++) {
            System.out.print(a[i] + " ");
        }

    }

    public static void printArray(int[] array) {
        for (int i = 0; i < array.length; i++)
            System.out.print(array[i] + " ");
        System.out.println();
    }
}
