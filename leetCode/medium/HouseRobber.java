package src.src.leetCode.medium;

public class HouseRobber {

    /*
    You are a professional robber planning to rob houses along a street.
    Each house has a certain amount of money stashed,
    the only constraint stopping you from robbing each of them is that adjacent houses have security systems connected,
    and it will automatically contact the police if two adjacent houses were broken into on the same night.
    Given an integer array nums representing the amount of money of each house,
    return the maximum amount of money you can rob tonight without alerting the police
    */

    public static int rob(int[] nums) {
        int n = nums.length;
        if(n==0){
            return 0;
        }else if(n==1){
            return nums[0];
        }else if(n==2){
            return Math.max(nums[0], nums[1]);
        }

        int [] dp = new int[n];
        dp[0] = nums[0];
        dp[1] = Math.max(dp[0], nums[1]);

        for (int i = 2; i < n; i++) {
            dp[i] = Math.max(dp[i-1], nums[i] + dp[i-2]);
        }

        return dp[n-1];
    }

    public static void main(String[] args) {
        int [] nums = new int[]{1,2,3,1}; // out -->> 4
        int result = rob(nums);
        System.out.println(result);
    }
}
