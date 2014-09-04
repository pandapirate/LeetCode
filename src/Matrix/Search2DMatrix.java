package Matrix;

/**
 * Created by Kevin on 9/2/14
 */
public class Search2DMatrix {

    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) return false;
        if (matrix[0][0] > target) return false;

        int horiz = 0;
        int i = 0;
        for (i = 0; i < matrix.length; i++) {
            if (matrix[i].length > 0) {
                if (matrix[i][0] > target) {
                    horiz = i-1;
                    break;
                }
            }
        }

        if (i == matrix.length) {
            horiz = matrix.length-1;
        }

        int low = 0;
        int high = matrix[horiz].length-1;

        while (low <= high) {
            int mid = low + (high - low)/2;

            if (matrix[horiz][mid] == target) {
                return true;
            } else if (matrix[horiz][mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return false;
    }

    public static void main(String args[]) {
        /*[
        [1,   3,  5,  7],
        [10, 11, 16, 20],
        [23, 30, 34, 50]
        ]*/

        int[][] matrix = new int[][]{{1,   3,  5,  7},{10, 11, 16, 20},{23, 30, 34, 50}};

        System.out.println(new Search2DMatrix().searchMatrix(matrix, 3));
        System.out.println(new Search2DMatrix().searchMatrix(matrix, 4));
    }
}
