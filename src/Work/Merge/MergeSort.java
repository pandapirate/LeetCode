package Merge;

// Recursive array sort
public class MergeSort {

    public static int[] list = {2, 5, 13, 8, 3, 44, 0,9, 7, 9, 6, 15, 33, 23, 67, 1, 23};

    public static void main (String[] args) throws Exception {
        System.out.println("Begin: ");
        for (int i : list) {
            System.out.print(i + " ");
        }
        System.out.println();

        int[] result = mergeSort(list);

        System.out.println("End: ");
        for (int i : result) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static int[] mergeSort(int[] array) {

        if (array.length == 1)
            return array;

        int half = array.length/2;
        int[] left = new int[half];
        int[] right = new int[array.length - half];

        for (int i = 0; i < half; i++) {
            left[i] = array[i];
        }

        int counter = 0;
        for (int i = half; i < array.length; i++) {
            right[counter] = array[i];
            counter++;
        }

        int[] result = merge(mergeSort(left), mergeSort(right));

        return result;
    }

    private static int[] merge(int[] left, int[] right) {
        int l = 0, r = 0;
        int[] result = new int[left.length + right.length];
        int counter = 0;
        while (counter != result.length) {
            if (l < left.length && r < right.length) {
                if (left[l] < right[r]) {
                    result[counter] = left[l];
                    counter++;
                    l++;
                } else {
                    result[counter] = right[r];
                    counter++;
                    r++;
                }
            } else if (l == left.length) {
                for (int i = r; i < right.length; i++) {
                    result[counter] = right[i];
                    counter++;
                    l++;
                }
            } else if (r == right.length) {
                for (int i = l; i < left.length; i++) {
                    result[counter] = left[i];
                    counter++;
                    r++;
                }
            }
        }

        return result;
    }
}
