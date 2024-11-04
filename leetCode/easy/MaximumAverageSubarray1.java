package src.src.leetCode.easy;

public class MaximumAverageSubarray1 {

    /*
    You are given an integer array nums consisting of n elements, and an integer k.
    Find a contiguous sub-array whose length is equal to k that has the maximum average value and return this value.
    */
    public static double findMaxAverage(int[] nums, int k) {

        if(k > nums.length){
            return 0.0;
        }

        int leftIndex = 0;
        int rightIndex = k - 1;
        int sum = 0;
        for(int i = 0; i < k; i++){
            sum += nums[i];
        }
        int maxSum = sum;

        while (rightIndex < nums.length - 1){
            sum = sum - nums[leftIndex] + nums[rightIndex+1];
            maxSum = Math.max(maxSum, sum);
            leftIndex++;
            rightIndex++;
        }
        return  maxSum /(double) k;

    }

    public static void main(String[] args) {
        System.out.println(findMaxAverage(new int[]{1,12,-5,-6,50,3}, 4));
    }
}
