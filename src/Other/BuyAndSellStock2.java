package Other;

/**
 * Created by khuang on 9/2/14.
 */
public class BuyAndSellStock2 {
    public int maxProfit(int[] prices) {
        int total = 0;
        for (int i=0; i< prices.length-1; i++) {
            if (prices[i+1]>prices[i]) total += prices[i+1]-prices[i];
        }

        return total;
    }

    public static void main(String args[]) {

    }
}
