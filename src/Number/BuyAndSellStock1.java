package Number;

/**
 * Created by khuang on 9/17/14.
 */
public class BuyAndSellStock1 {
    public int maxProfit(int[] prices) {
        if (prices.length <= 1) return 0;

        int min = prices[0];
        int profit = 0;

        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < min) {
                min = prices[i];
            } else if (prices[i] - min > profit) {
                profit = prices[i] - min;
            }
        }
        return profit;
    }

    public static void main(String args[]) {

    }
}
