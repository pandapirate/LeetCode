package Merge;

// In place merge sort
public class MergeSort2 {

    public static int[] list = {2, 5, 13, 8, 3, 44, 0,9, 7, 9, 6, 15, 33, 23, 67, 1, 23};

    public static void main (String[] args) throws Exception {
        System.out.println("Begin: ");
        for (int i : list) {
            System.out.print(i + " ");
        }
        System.out.println();

        mergeSort(0, list.length-1);

        System.out.println("End: ");
        for (int i : list) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static int[] mergeSort(int left, int right) {
        int[] range = new int[2];

        if (left == right) {
            range[0] = left;
            range[1] = right;
        } else {
            int mid = (right - left)/2;

            range = merge(mergeSort(left, mid), mergeSort(mid+1, right));
        }
        return range;
    }

    private static int[] merge(int[] left, int[] right) {

        int counter = 0;
        int total = right[1] - left[0];

        int l = left[0];
        int r = right[0];

        while (counter != total) {
            if (l < left[1] && r < right[1]) {

            } else if (l == left[1]) {
                for (int i = r; i < right[1] ; i++) {

                }
            }


        }

        return null;
    }

    private static void swap (int x, int y) {
        int a = list[x];
        list[x] = list[y];
        list[y] = a;
    }
}
