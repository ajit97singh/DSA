package src.src.algoexpert.easy;

import java.util.Arrays;

public class MinimumNonConstructibleChange {


    public static int nonConstructibleChange(int[] coins) {
        int maxChangeCreated = 0;
        Arrays.sort(coins);

        for (int coin : coins) {
            if (coin > maxChangeCreated + 1) {
                return maxChangeCreated + 1;
            } else {
                maxChangeCreated += coin;
            }
        }
        return maxChangeCreated + 1;
    }

    public static void main(String[] args) {
        System.out.println(nonConstructibleChange(new int[]{1, 2, 2, 5, 10, 20, 20, 50, 100, 200, 200}));
    }
}
