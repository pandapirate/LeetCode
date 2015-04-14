package HackerRank;

import java.io.FileReader;
import java.util.Scanner;

public class FindTheMedian {

    public static int[] list;

    public static void main(String args[]) throws Exception {
        Scanner in = new Scanner(System.in);
        in = new Scanner(new FileReader("src/HackerRank/TestData/median"));

        int N = in.nextInt();
        list = new int[N];

        for (int i = 0; i < N; i++) {
            list[i] = in.nextInt();
        }
        quickSort(0, N-1);
        System.out.println(list[N/2]);
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
