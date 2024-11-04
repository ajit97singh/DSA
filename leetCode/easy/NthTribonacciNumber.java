package src.src.leetCode.easy;

public class NthTribonacciNumber {
    /*
    * The Tribonacci sequence Tn is defined as follows:
    * T0 = 0, T1 = 1, T2 = 1, and Tn+3 = Tn + Tn+1 + Tn+2 for n >= 0.
    * Given n, return the value of Tn.
    */

    public static int tribonacci(int n) {
        if(n==0){
            return 0;
        }else if(n<3){
            return 1;
        }
        int [] dp = new int[n+1];
        dp[1] = dp[2] = 1;
        for(int i=3; i<=n; i++){
            dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
        }
        return dp[n];
    }

    public static void main(String[] args) {
        int input = 4;
        // output --> 4
        System.out.println(tribonacci(input));
    }
}
