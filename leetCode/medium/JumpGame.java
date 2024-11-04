package src.src.leetCode.medium;

public class JumpGame {

    /*
    * You are given an integer array nums. You are initially positioned at the array's first index,
    * and each element in the array represents your maximum jump length at that position.
    * Return true if you can reach the last index, or false otherwise.
    */


    public static boolean canJump(int[] nums) {

        boolean[] dp = new boolean[nums.length];
        if(nums.length == 1) return true;
        dp[0] = true;
        for (int i = 0; i < nums.length; i++) {

            if (nums[i] == 0 && !dp[i] ) {
                return false;
            }
            int element = nums[i];
            int j = i ;
            while (element > 0 && j < nums.length-1) {

                dp[j+1] = true;
                j++;
                element--;

            }

        }

        for(boolean element: dp) {
            if(!element) {
                return false;
            }
        }
        return true;
    }

    public static boolean canJumpOptimized(int[] nums) {
        // think of it as car with petrol picking up on the way
        if(nums.length == 1) return true;
        int gas = nums[0];
        int position = 0;
        while (gas > 0) {
            position++;
            if(position == nums.length-1) {
                return true;
            }
            gas--;
            gas = Math.max(nums[position], gas);
        }
        return false;
    }



    public static void main(String[] args) {
        int[] input = new int[]{3,0,0,2,3};
        boolean canJump = canJump(input);
        System.out.println(canJump);
    }
}
