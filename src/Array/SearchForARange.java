package Array;

/**
 * Created by khuang on 9/17/14.
 */
public class SearchForARange {
    public int[] searchRange(int[] A, int target) {
        int[] results = new int[]{-1,-1};

        int index = -1;
        int lo = 0; int hi = A.length-1;
        while (lo <= hi) {
            int mid = lo + (hi-lo)/2;

            if (A[mid] == target) {
                index = mid; break;
            } else if (target < A[mid]) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }

        if (index != -1) {
            int low = index; int high = index;
            boolean lowFound = false, highFound = false;
            while (true) {
                if (low - 1 >= 0) {
                    if (A[low-1] == target)
                    {
                        low--;
                    } else {
                        lowFound = true;
                    }
                } else {
                    lowFound = true;
                }

                if (high + 1 < A.length) {
                    if (A[high+1] == target)
                    {
                        high++;
                    } else {
                        highFound = true;
                    }
                } else {
                    highFound = true;
                }

                if (lowFound && highFound)
                    break;
            }

            results[0] = low;
            results[1] = high;
        }

        return results;
    }

    public static void main(String args[]) {
        int[] range = new int[]{1};

        int[] result = new SearchForARange().searchRange(range, 1);
        printArray(result);
    }

    public static void printArray(int[] array) {
        for (int i = 0; i < array.length; i++)
            System.out.print(array[i] + " ");
        System.out.println();
    }
}
