package Random;

public class MaximumSubarray {
  public int maxSubArray(int[] A) {
    int max = A[0];
    int curCount = A[0];
    for (int i = 1; i < A.length; i++) {
      curCount = Math.max(A[i], curCount + A[i]);
      max = Math.max(max, curCount);
    }

    return max;
  }

  public int maxProduct(int[] A) {
    int max = A[0];
    int curCount = A[0];
    for (int i = 1; i < A.length; i++) {
      curCount = Math.max(A[i], curCount * A[i]);
      max = Math.max(max, curCount);
    }

    return max;
  }

  public static void main (String[] args) {
    int[] stuff = new int[]{2,3,-2,4};
    System.out.println(new MaximumSubarray().maxProduct(stuff));
  }
}
