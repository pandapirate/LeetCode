package AI;

/**
 * Created by Kevin on 10/11/2014.
 */
public class UniquePaths {

    private int height;
    private int width;
    private int count;

    public int uniquePaths(int m, int n) {
        height = m;
        width = n;
        count = 0;

        move(1,1);
        return count;
    }

    private void move(int x, int y) {
        if (x == width && y == height) {
            count++;
        } else {
            if (x < width) {
                move(x+1, y);
            }

            if (y < height) {
                move(x, y+1);
            }
        }
    }

    public static void main (String[] args) {
        int m = 23, n = 12;

        System.out.println(new UniquePaths().uniquePaths(m, n));
    }
}
