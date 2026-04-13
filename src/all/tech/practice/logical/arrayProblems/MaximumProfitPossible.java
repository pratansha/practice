package all.tech.practice.logical.arrayProblems;

// Write a program that determines the maximum profit possible. If no profit can be made, return 0.
public class MaximumProfitPossible {
    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};
        System.out.println(getMaxProfit(prices));

        int[] prices2 = {7, 6, 5, 3, 2, 1};
        System.out.println(getMaxProfit(prices2));
        System.out.println(getMaxProfitAndDay(prices2));
        System.out.println("========================================");
        System.out.println(getMaxProfitTest(prices));
        System.out.println(getMaxProfitTest(prices2));
        System.out.println(getMaxProfitTest2(prices));
        System.out.println(getMaxProfitTest2(prices2));
    }

    public static int getMaxProfit(int[] prices) {
        int minPrice = prices[0];
        int minPriceDay = 1;

        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (maxProfit < (prices[i] - minPrice)) {
                maxProfit = (prices[i] - minPrice);
            }
            if (minPrice > prices[i]) {
                minPrice = prices[i];
                minPriceDay = i + 1;
            }
        }
        System.out.println("minPrice :" + minPrice + " on day :" + minPriceDay);
        return maxProfit;
    }

    public static int getMaxProfitAndDay(int[] prices) {
        int min = prices[0];
        int maxProfit = 0;
        int minPriceDay = 0;
        for (int i = 0; i < prices.length; i++) {
            if (min > prices[i]) {
                min = prices[i];
                minPriceDay = i + 1;
            }
            if (maxProfit < prices[i] - min) {
                maxProfit = prices[i] - min;
            }
        }
        System.out.println("minPrice :" + min + " on day :" + minPriceDay);
        return maxProfit;
    }

    public static int getMaxProfitTest(int[] prices) {
        int maxProfit = 0;
        int min = prices[0];
        for (int i = 1; i < prices.length; i++) {
            min = Math.min(min, prices[i]);
            maxProfit = Math.max(maxProfit, prices[i] - min);
        }
        return maxProfit;
    }

    public static int getMaxProfitTest2(int[] prices) {
        int maxProfit = 0;
        int min = prices[0];
        for (int i = 1; i < prices.length; i++) {
            min = Math.min(min, prices[i]);
            maxProfit = Math.max(maxProfit, prices[i] - min);
        }
        return maxProfit;
    }

}