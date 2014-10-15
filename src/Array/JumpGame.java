package Array;

/**
 * Created by Kevin on 10/14/2014.
 */
public class JumpGame {
    public boolean canJump(int[] A) {
        if (A.length == 0) return false;

        int pos = 0;
        while (pos < A.length-1) {
            if (A[pos] == 0)
                return false;
            else
                pos += A[pos];
        }

        return true;
    }

    public boolean jump(int[] A, int index) {
        
    }

    public static void main(String[] args) {
        int[] A = new int[]{1,2,3};
        int[] B = new int[]{2,5,0,0};

        JumpGame game = new JumpGame();
        System.out.println(game.canJump(A));
        System.out.println(game.canJump(B));
    }
}
