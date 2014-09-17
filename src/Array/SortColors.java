package Array;

/**
 * Created by Kevin on 9/16/2014.
 */
public class SortColors {

    public void sortColors(int[] A) {
        if (A.length <= 1) return;

        int a = -1, b = -1, c = -1;

        for (int i = 0; i < A.length; i++) {
            if (A[i] == 0) {
                A[++c] = 2;
                A[++b] = 1;
                A[++a] = 0;
            } else if (A[i] == 1) {
                A[++c] = 2;
                A[++b] = 1;
            } else {
                A[++c] = 2;
            }
        }
    }

    public void twoPass(int[] A) {
        int a = 0;
        int b = 0;
        int c = 0;

        for (int x : A) {
            if (x == 0) a++;
            else if (x == 1) b++;
            else c++;
        }

        int index = 0;
        for (int i = 0; i < a; i++) {
            A[index++] = 0;
        }
        for (int i = 0; i < b; i++) {
            A[index++] = 1;
        }
        for (int i = 0; i < c; i++) {
            A[index++] = 2;
        }
    }

    public static void main(String[] args) {
//        int[] array = new int[]{1, 2, 1, 2, 0, 0, 1, 2, 0};
        int[] array = new int[]{1, 0};

        new SortColors().sortColors(array);
        for (int x : array) {
            System.out.print(x + " ");
        }
    }
}
