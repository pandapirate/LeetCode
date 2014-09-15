package Matrix;

/**
 * Created by Kevin on 9/14/2014
 */
public class RotateMatrix {
    public void rotate(int[][] matrix) {
        if (matrix.length <= 1) return;

        int curVal = 0;
        int l = matrix.length;

        for (int i = 0; i < l - 1; i++) {
            for (int j = i; j < l-1-i; j++) {

            }
        }
    }

    public static void main(String args[]) {
        /*[
        [1,   3,  5,  7],
        [10, 11, 16, 20],
        [23, 30, 34, 50]
        ]*/

        int[][] matrix = new int[][]{{1,   2,  3, 4},{5, 6, 7, 8},{9, 10, 11, 12},{13, 14, 15, 16}};
        new RotateMatrix().rotate(matrix);

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
