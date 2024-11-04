package src.src.leetCode.easy;

public class SearchInsertPosition {
    public static int searchInsert(int[] nums, int target) {
        if(nums.length == 0){
            return 0;
        }
        int lowIndex = 0;
        int highIndex = nums.length - 1;
        int midIndex = (lowIndex+highIndex)/2 ;
        int midValue = nums[midIndex];

        while(target != midValue){
            int highValue = nums[highIndex];
            int lowValue = nums[lowIndex];
            if(target <= lowValue){
                return lowIndex;
            }else if(target >highValue){
                return highIndex + 1;
            }
            if((highIndex-lowIndex)<=1){
                return lowIndex+1;
            }
            midIndex = (lowIndex+highIndex)/2 ;
            midValue = nums[midIndex];
            if (target == midValue){
                return midIndex;
            }else if (target < midValue){
                highIndex = midIndex - 1;
            }else {
                lowIndex = midIndex + 1;
            }
        }
        return midIndex;
    }

    public static void main(String[] args) {
        System.out.println(searchInsert(new int[]{1,3,5,6}, 5));
    }
}
