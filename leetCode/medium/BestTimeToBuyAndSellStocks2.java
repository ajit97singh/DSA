package src.src.leetCode.medium;

public class BestTimeToBuyAndSellStocks2 {

    /*
    * You are given an integer array prices where prices[i] is the price of a given stock on the ith day.
    * On each day, you may decide to buy and/or sell the stock.
    * You can only hold at most one share of the stock at any time.
    * However, you can buy it then immediately sell it on the same day.
    * Find and return the maximum profit you can achieve.
    */

    int solution(int[] prices) {
        int profit = 0;
        for (int i = 0; i < prices.length-1; i++) {

            int currentPrice = prices[i];
            int nextDayPrice = prices[i+1];

            if (currentPrice < nextDayPrice) {
                // sell
                profit += nextDayPrice-currentPrice;
            }


        }


        return profit;
    }


    public static void main(String[] args) {
        int [] prices = {1,2,3,2,1,5};
        int res = new BestTimeToBuyAndSellStocks2().solution(prices);
        res = 1;
    }
}
