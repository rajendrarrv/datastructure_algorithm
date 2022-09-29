package com.rajendra.practice.apna;

/**
 * Created by Rajendra Verma on 26/09/22.
 */
public class StockMarket {

    //    BON2
    public int maxProfitBrutForce(int[] prices) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < prices.length; i++) {
            for (int j = i + 1; j < prices.length - 1; j++) {
                int profit = prices[j] - prices[i];
                max = Math.max(max, profit);
            }
        }
        return max;
    }

    //    BON
    public int maxProfitOpt(int[] prices) {
        int maxPrice = Integer.MIN_VALUE;
        for (int i = prices.length - 1; i > 0; i--) {
            maxPrice = Math.max(prices[i], maxPrice);
        }
        int maxProfit = 0;
        for (int i = 0; i < prices.length; i++) {

            int profit = maxPrice - prices[i];
            maxProfit = Math.max(profit, maxProfit);
        }

        return maxProfit;
    }

    //    BNL
    public int maxProfitOpt1(int[] prices) {
        int minSoFar = Integer.MAX_VALUE;
        int maxProfit = Integer.MIN_VALUE;

        for (int i = 0; i < prices.length; i++) {

            minSoFar = Math.min(prices[i], minSoFar);

            int profit = prices[i] - minSoFar;
            maxProfit = Math.max(maxProfit, profit);

        }


        return maxProfit;
    }
}
