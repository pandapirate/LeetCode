package Array;

/**
 * Created by khuang on 8/26/14.
 */
public class SearchInsertPosition {

    public int searchInsert(int[] A, int target) {
        if (target <= A[0])
            return 0;
        if (target > A[A.length-1])
            return A.length;
        else if (target == A[A.length-1])
            return A.length-1;

        //binary search
        int bot = 0;
        int top = A.length-1;
        int diff = (top-bot)/2;
        int middle = bot + (diff == 0 ? 1 : diff);

        while (bot < top) {
            if (A[middle] == target) {
                return middle;
            } else if (A[middle] < target) {
                bot = middle + 1;
                diff = (top-bot)/2;
                middle = bot + (diff == 0 ? 1 : diff);
            } else {
                top = middle - 1;
                if (top == bot) {
                    break;
                }
                diff = (top-bot)/2;
                middle = bot + (diff == 0 ? 1 : diff);
            }
        }

        return middle;
    }

    public static void main(String args[]) {
        SearchInsertPosition search = new SearchInsertPosition();

        System.out.println(search.searchInsert(new int[]{1, 3, 5, 6}, 5)); //2
        System.out.println(search.searchInsert(new int[]{1, 3, 5, 6}, 2)); //1
        System.out.println(search.searchInsert(new int[]{1, 3, 5, 6}, 7)); //4
        System.out.println(search.searchInsert(new int[]{1, 3, 5, 6}, 0)); //0
        System.out.println(search.searchInsert(new int[]{1, 3}, 3)); //1
        System.out.println(search.searchInsert(new int[]{1, 2, 4, 6, 7}, 3)); //1
    }
}
