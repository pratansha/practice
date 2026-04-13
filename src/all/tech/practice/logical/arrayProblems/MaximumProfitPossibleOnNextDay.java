package all.tech.practice.logical.arrayProblems;

//On each day, you may decide to buy and/or sell the stock. You can only hold at most one share of the stock at any time. However, you can buy it then immediately sell it on the same day.
public class MaximumProfitPossibleOnNextDay {
    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};

        // First way to solve this.
        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i - 1] < prices[i]) {
                maxProfit += (prices[i] - prices[i - 1]);
            }
        }
        System.out.println(maxProfit);

        // Other way to solve this.
        int maxProfitTotal = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            maxProfitTotal = maxProfitTotal + Math.max(0, prices[i + 1] - prices[i]);
        }
        System.out.println(maxProfitTotal);
    }
}
