package src.src.leetCode.medium;

public class DominoAndTrominoTiling {
    /*
    You have two types of tiles: a 2 x 1 domino shape and a tromino shape. You may rotate these shapes.
    Given an integer n, return the number of ways to tile an 2 x n board.
    Since the answer may be very large, return it modulo 10^9 + 7.
    In a tiling, every square must be covered by a tile.
    Two tilings are different if and only if there are two 4-directionally adjacent cells on the board such that
    exactly one of the tilings has both squares occupied by a tile.
    */
    // Unsolved
    public static int numTilings(int n) {
        if (n == 0) {
            return 0;
        }else if (n==1) {
            return 1;
        }else if (n==2) {
            return 2;
        }
        int[] dp = new int[n];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i < n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2] * 2 + dp[i - 3] * 5;
        }
        return dp[n - 1];
    }

    public static void main(String[] args) {
        int input = 4;
        int output = numTilings(input);
        System.out.println(output);
    }
}
