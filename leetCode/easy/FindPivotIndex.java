package src.src.leetCode.easy;

public class FindPivotIndex {
    /*
    * Given an array of integers nums, calculate the pivot index of this array.
    * The pivot index is the index where the sum of all the numbers strictly to the left of the index is equal to the
    * sum of all the numbers strictly to the index's right.
    * If the index is on the left edge of the array, then the left sum is 0 because there are no elements to the left.
    *  This also applies to the right edge of the array.
    * Return the leftmost pivot index. If no such index exists, return -1.
    */

    public static int pivotIndex(int[] nums) {
        int [] sumTracker = new int[nums.length + 1];
        sumTracker[0] = 0;
        for(int i = 0; i<nums.length; i++){
            sumTracker[i+1] = sumTracker[i] + nums[i];
        }
        int totalSum = sumTracker[sumTracker.length - 1];
        for(int i = 1; i<sumTracker.length; i++){
            if((sumTracker[i] - nums[i - 1]) == (totalSum - sumTracker[i]) ){
                return i - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        // output 3
        System.out.println(pivotIndex(new int[]{1,7,3,6,5,6}));
    }
}
