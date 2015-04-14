package HackerRank;

import java.io.FileReader;
import java.util.Scanner;

public class BuyingFlower {

    public static int[] list;

    public static void main(String args[]) throws Exception {
        Scanner in = new Scanner(System.in);
        in = new Scanner(new FileReader("src/HackerRank/TestData/flowers"));

        int n = in.nextInt();
        int k = in.nextInt();

        list = new int[n];
        for(int i = 0; i < n; i++) {
            list[i] = in.nextInt();
        }
        quickSort(0, n-1);

        int num = n / k;
        int remainder = n%k;

        int total = 0;

        for (int i = 0; i < k; i++) {
            if (i < k-1) {
                for (int j = 0; j < num; j++) {
                    int index = i * num + j;
                    total += list[index]*(j+1);
                }
            } else {
                for (int j = 0; j < num+remainder; j++) {
                    int index = i * num + j;
                    total += list[index]*(j+1);
                }
            }
        }

        System.out.println(total);
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
            if (list[i] > pivot) {
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
