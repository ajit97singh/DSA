package src.src.leetCode.medium;

public class FirstAndLastPositionOfElementInSortedArray {
    public static int[] searchRange(int[] nums, int target) {
        int resultLeft = -1;
        int resultRight = -1;
        if(nums[0] == target){
            resultLeft = 0;
        }
        if(nums[nums.length -1 ] == target){
            resultRight = nums.length -1;
        }
        int leftIndex = 0;
        int rightIndex = nums.length - 1;
        int leftValue = nums[leftIndex];
        int rightValue = nums[rightIndex];
        boolean leftFound = false;
        boolean rightFound = false;
        while (!leftFound || !rightFound){

        }

        return new int[]{resultLeft, resultRight};
    }

    public static void main(String[] args) {
        System.out.println();
    }
}
