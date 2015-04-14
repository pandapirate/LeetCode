package HackerRank;

import java.io.FileReader;
import java.util.Scanner;

public class BillGates {

    public static int[] list;

    public static void main(String args[]) throws Exception {
        Scanner in = new Scanner(System.in);
        in = new Scanner(new FileReader("src/HackerRank/TestData/billgates"));

        int n = Integer.parseInt(in.nextLine());
        int k = Integer.parseInt(in.nextLine());

        list = new int[n];
        for(int i = 0; i < n; i++) {
            list[i] = Integer.parseInt(in.nextLine());
        }
        quickSort(0, n-1);
        int min = list[k-1] - list[0];
        for (int i = 1; i <= n-k; i++) {
            int val = list[i+k-1] - list[i];
            if (val < min) {
                min = val;
            }
        }
        System.out.println(min);
    }

    public static void quickSort(int start, int end) {
        if (end <= start)
            return;

        int pivot = start + (end - start)/2;
        int result = sortAndSplit(start, end, pivot);

        quickSort(start, result-1);
        quickSort(result + 1, end);
    }

    public static int sortAndSplit(int start, int end, int split) {
        int pivot = list[split];
        swap(end, split);

        int front = start;
        for (int i = start; i < end; i++) {
            if (list[i] < pivot) {
                swap(i, front);
                front++;
            }
        }
        swap (front, end);
        return front;
    }

    public static void swap (int x, int y) {
        int a = list[x];
        list[x] = list[y];
        list[y] = a;
    }
}
