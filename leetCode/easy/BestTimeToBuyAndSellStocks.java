package src.src.leetCode.easy;

public class BestTimeToBuyAndSellStocks {
    /*
    * You are given an array prices where prices[i] is the price of a given stock on the ith day.
    * You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.
    * Return the maximum profit you can achieve from this transaction.
    * If you cannot achieve any profit, return 0.
    */

    public int solution(int[] prices) {


        int profit = 0;
        int minPrice = Integer.MAX_VALUE;
        for (int currentPrice : prices) {
            if (currentPrice < minPrice) {
                minPrice = currentPrice;
            }
            profit = Math.max(profit, currentPrice - minPrice);
        }
        return profit;
    }

    public static void main(String [] args) {
        int[] input = {1,2};
        int res = new BestTimeToBuyAndSellStocks().solution(input);
        res = 1;
    }

}
