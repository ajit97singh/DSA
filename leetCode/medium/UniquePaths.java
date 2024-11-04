package src.src.leetCode.medium;

public class UniquePaths {

    /*
    There is a robot on an m x n grid. The robot is initially located at the top-left corner (i.e., grid[0][0]).
    The robot tries to move to the bottom-right corner (i.e., grid[m - 1][n - 1]).
    The robot can only move either down or right at any point in time.
    Given the two integers m and n,
    return the number of possible unique paths that the robot can take to reach the bottom-right corner.
    */

    public static int uniquePaths(int m, int n) {

        if (m == 0 || n == 0 || m == 1 || n == 1) {
            return 1;
        }

        int [][] dp = new int[m][n];
        dp[0][0] = 1;
        dp[0][1] = 1;
        dp[1][0] = 1;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if ( i > 0 && j > 0) {
                    dp[i][j] = dp[i-1][j] + dp[i][j-1];
                } else if (i > 0) {
                    dp[i][j] = dp[i-1][j];
                } else if (j > 0) {
                    dp[i][j] = dp[i][j-1];
                }
            }
        }

        return dp[m-1][n-1];
    }

    public static void main(String[] args) {
        int m = 3;
        int n = 7;
        int output = uniquePaths(m, n); // 28
        System.out.println(output);
    }

}
